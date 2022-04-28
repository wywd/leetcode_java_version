/**
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 

 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 

 返回容器可以储存的最大水量。 

 说明：你不能倾斜容器。 

 

 示例 1： 

 

 
输入：[1,8,6,2,5,4,8,3,7]
输出：49 
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 

 示例 2： 

 
输入：height = [1,1]
输出：1
 

 

 提示： 

 
 n == height.length 
 2 <= n <= 10⁵ 
 0 <= height[i] <= 10⁴ 
 
 Related Topics 贪心 数组 双指针 👍 3301 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new L_11_ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{1, 0, 0, 0, 0, 0, 0, 2, 2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 2) {
            return Math.min(height[0], height[1]);
        }
        int res = 0;
        int[] temp = new int[len];
        int cur = 0;
        int pre = 0;
        for (int i = 1; i < len; i++) {
            if (height[i] >= height[temp[cur]]) {
                int p = cur;
                while (p >= cur) {
                    int area = height[temp[p]] * (i - temp[p]);
                    if (area > res) {
                        res = area;
                    }
                    p--;
                }
                temp[++cur] = i;
            } else {
                for (int j = pre; j <= cur; j++) {
                    int h = Math.min(height[temp[j]], height[i]);
                    int w = i - temp[j];
                    int area = h * w;
                    if (area > res) {
                        res = area;
                        pre++;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}