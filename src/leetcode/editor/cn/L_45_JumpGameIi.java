/**
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 

 数组中的每个元素代表你在该位置可以跳跃的最大长度。 

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 

 假设你总是可以到达数组的最后一个位置。 

 

 示例 1: 

 
输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 

 示例 2: 

 
输入: nums = [2,3,0,1,4]
输出: 2
 

 

 提示: 

 
 1 <= nums.length <= 10⁴ 
 0 <= nums[i] <= 1000 
 
 Related Topics 贪心 数组 动态规划 👍 1380 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_45_JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new L_45_JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{2,1,1,1,4}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int path = 0;  // 跳到终点的次数
        int cur = 0;  // 当前位置
        int cover = 0;  // 当前可以跳的范围
        while (cover < nums.length - 1) {  // 可以跳到的范围还没有覆盖到终点的话
            int max = 0;  // 局部值，用来统计当前范围内所有点可以跳到的最大范围，用于更新cover
            for (int i = cur; i <= cover; i++) {  // 在当前范围内搜索
                int tmp = i + nums[i];
                if (tmp > max) {
                    max = tmp;
                    cur = i;
                }
            }
            cover = max;  // 更新的覆盖范围
            path++;  // 跳跃次数+1
        }
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}