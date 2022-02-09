/**
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 

 求在该柱状图中，能够勾勒出来的矩形的最大面积。 

 

 示例 1: 

 

 
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
 

 示例 2： 

 

 
输入： heights = [2,4]
输出： 4 

 

 提示： 

 
 1 <= heights.length <=10⁵ 
 0 <= heights[i] <= 10⁴ 
 
 Related Topics 栈 数组 单调栈 👍 1741 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class L_84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new L_84_LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
                int h = heights[stack.removeLast()];
                while (!stack.isEmpty() && heights[stack.getLast()] == h) {
                    stack.removeLast();
                }
                int w;
                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - stack.getLast() - 1;
                }
                area = Math.max(area, w * h);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int h = heights[stack.removeLast()];
            while (!stack.isEmpty() && heights[stack.getLast()] == h) {
                stack.removeLast();
            }
            int w;
            if (stack.isEmpty()) {
                w = len;
            } else {
                w = len - stack.getLast() - 1;
            }
            area = Math.max(area, w * h);
        }

        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}