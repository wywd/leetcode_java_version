/**
给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 

 

 示例 1： 

 
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
 

 示例 2： 

 
输入：n = 1
输出：[[1]]
 

 

 提示： 

 
 1 <= n <= 20 
 
 Related Topics 数组 矩阵 模拟 👍 593 👎 0

*/

package leetcode.editor.cn;

public class L_59_SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new L_59_SpiralMatrixIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0;  // 行
        int y = 0;  // 列
        int status = 0;  // 0向右 -> 1向下 -> 2向左 -> 3向上
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            if (status == 0) {
                if (y + 1 == n || res[x][y+1] > 0) {
                    x++;
                    status = 1;
                } else {
                    y++;
                }
            } else if (status == 1) {
                if (x + 1 == n || res[x+1][y] > 0) {
                    y--;
                    status = 2;
                } else {
                    x++;
                }
            } else if (status == 2) {
                if (y == 0 || res[x][y - 1] > 0) {
                    x--;
                    status = 4;
                } else {
                    y--;
                }
            } else {
                if (x == 0 || res[x - 1][y] > 0) {
                    y++;
                    status = 0;
                } else {
                    x--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}