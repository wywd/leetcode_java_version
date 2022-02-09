/**
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 

 

 示例 1： 

 

 
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 

 示例 2： 

 
输入：height = [4,2,0,3,2,5]
输出：9
 

 

 提示： 

 
 n == height.length 
 1 <= n <= 2 * 10⁴ 
 0 <= height[i] <= 10⁵ 
 
 Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3071 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L_42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new L_42_TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{4, 2, 0, 3, 2, 5}));
//        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 双指针法
//        int sum = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            int left = height[i];
//            int right = height[i];
//            for (int l = 0; l < i; l++) {
//                if (height[l] > left) {
//                    left = height[l];
//                }
//            }
//            for (int r = i+1; r < height.length; r++) {
//                if (height[r] > right) {
//                    right = height[r];
//                }
//            }
//            sum += Math.min(left, right) - height[i];
//        }
//        return sum;
        // 动态规划
//        int len = height.length;
//        if (len <= 2) {
//            return 0;
//        }
//        int[] maxLeft = new int[len];
//        int[] maxRight = new int[len];
//        maxLeft[0] = height[0];
//        for (int i = 1; i < len; i++) {
//            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
//        }
//        maxRight[len - 1] = height[len - 1];
//        for (int i = len - 2; i >= 0; i--) {
//            maxRight[i] = Math.max(height[i], maxRight[i+1]);
//        }
//        int sum = 0;
//        for (int i = 1; i < len - 1; i++) {
//            sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
//        }
//        return sum;
        // 单调栈 (单调栈是按行计算的)
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int sum = 0;
        for (int i = 1; i < len; i++) {
            int stackTop = stack.getLast();
            if (height[i] < height[stackTop]) {
                stack.addLast(i);
            } else if (height[i] == height[stackTop]) {
                stack.removeLast();
                stack.addLast(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stackTop]) {
                    int min = height[stack.removeLast()];
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[stack.getLast()], height[i]) - min;
                        int w = i - stack.getLast() - 1;
                        sum += h*w;
                        stackTop = stack.getLast();
                    }
                }
                stack.addLast(i);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}