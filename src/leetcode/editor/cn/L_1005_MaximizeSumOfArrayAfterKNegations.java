/**
给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 

 
 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
 

 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 

 以这种方式修改数组后，返回数组 可能的最大和 。 

 

 示例 1： 

 
输入：nums = [4,2,3], k = 1
输出：5
解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 

 示例 2： 

 
输入：nums = [3,-1,0,2], k = 3
输出：6
解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 

 示例 3： 

 
输入：nums = [2,-3,-1,5,-4], k = 2
输出：13
解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 

 

 提示： 

 
 1 <= nums.length <= 10⁴ 
 -100 <= nums[i] <= 100 
 1 <= k <= 10⁴ 
 
 Related Topics 贪心 数组 排序 👍 207 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_1005_MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new L_1005_MaximizeSumOfArrayAfterKNegations().new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[]{-4, -3, 2, 5, -1}, 5));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        最初的思考方式：按照从小到大排序，然后边翻转边不断找当前的最小值的位置 // 后来：不用翻转，边移动边sum就好了
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 1) {  // 单独考虑数组长度为1的情况
            return k % 2 == 1 ? -nums[0] : nums[0];
        }
        Arrays.sort(nums);
        int cur = 0;
        int sum = 0;
        int length = nums.length;
        while (k>0) {
            if (nums[cur] < 0 ) {
                // 还有后面一位并且后面一位更小，那么移动到后面去，其实就是贪婪的思想，每次翻转最小值，难点在于如何确定当前的最小值
                if (cur + 1 < length && - nums[cur] > nums[cur + 1]) {  // - nums[cur]一定要有负号
                    sum -= nums[cur];  // 减负数就是加
                    cur++;
                } else {
                    nums[cur] = -nums[cur];
                }
            } else {
                nums[cur] = -nums[cur];
            }
            k--;
        }
        while (cur < length) {
            sum += nums[cur++];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}