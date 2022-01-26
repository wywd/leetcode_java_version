/**
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 

 数组中的每个元素代表你在该位置可以跳跃的最大长度。 

 判断你是否能够到达最后一个下标。 

 

 示例 1： 

 
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 

 示例 2： 

 
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 

 

 提示： 

 
 1 <= nums.length <= 3 * 10⁴ 
 0 <= nums[i] <= 10⁵ 
 
 Related Topics 贪心 数组 动态规划 👍 1603 👎 0

*/

package leetcode.editor.cn;


public class L_55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new L_55_JumpGame().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初步的想法：要到达当前位置，就找前面可以到达当前位置的位置，然后再反复更新，如果可以到开头，就True
    // 感觉有点动态规划的意思
//    public boolean canJump(int[] nums) {
//        if (nums.length == 1) {
//            return true;
//        }
//        boolean res = false;
//        int cur = nums.length - 1;
//        for (int i = cur - 1; i >= 0; i--) {
//            if (nums[i] >= cur - i) {
//                res = true;
//                cur = i;
//            } else {
//                res = false;
//            }
//        }
//        return res;
//    }
    // curl的贪心思想：每次移动范围确定当前的局部覆盖范围，如果可以覆盖到终点就说明可以达到
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {  // i在当前范围的元素中移动
            cover = Math.max(cover, i+nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}