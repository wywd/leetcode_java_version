/**
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 

 返回这三个数的和。 

 假定每组输入只存在恰好一个解。 

 

 示例 1： 

 
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

 示例 2： 

 
输入：nums = [0,0,0], target = 1
输出：0
 

 

 提示： 

 
 3 <= nums.length <= 1000 
 -1000 <= nums[i] <= 1000 
 -10⁴ <= target <= 10⁴ 
 
 Related Topics 数组 双指针 排序 👍 1122 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_16_ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new L_16_ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{0, 1, 2}, 3));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i <= len - 3; i++) {  // 先确定第一个数字
            int target2 = target - nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int step = target2 - nums[left] - nums[right];
                if (step == 0) {
                    return target;
                } else {
                    int gap = Math.abs(step);
                    if (gap < temp) {
                        temp = gap;
                        res = nums[i] + nums[left] + nums[right];
                    }
                    if (step < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            if (target < nums[i] && nums[i] >= 0) {
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}