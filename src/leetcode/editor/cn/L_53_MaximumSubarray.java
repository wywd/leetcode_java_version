/**
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 

 子数组 是数组中的一个连续部分。 

 

 示例 1： 

 
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 

 示例 2： 

 
输入：nums = [1]
输出：1
 

 示例 3： 

 
输入：nums = [5,4,-1,7,8]
输出：23
 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 

 

 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
 Related Topics 数组 分治 动态规划 👍 4268 👎 0

*/

package leetcode.editor.cn;

public class L_53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new L_53_MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, -1}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)

// 贪心的思想(想不到...)，一个一个的加，如果temp变大了，就更新max的值，
// 如果temp比0小了，那么就要消除前面的影响，temp重新开始
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp > max) {
                max = temp;
            }
            if (temp < 0) {
                temp = 0;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}