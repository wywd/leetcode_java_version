/**
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 

 

 示例 1： 

 
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
 

 示例 2： 

 
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

 

 提示： 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 10 
 -100 <= matrix[i][j] <= 100 
 
 Related Topics 数组 矩阵 模拟 👍 983 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class L_54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new L_54_SpiralMatrix().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int status = 0;  // 表示当前的状态，分别为 0右移 1下移 2左移 3上移，触发边界条件会改变状态:0->1->2->3->0->...
        int border0 = n - 1, border1 = m - 1, border2 = 0, border3 = 1;  // 初始边界，当某个状态完成后值会改变
        int i = 0, j = 0;
        for (int k = 0; k < m*n; ++k) {
            switch (status) {
                case 0: {
                    result.add(matrix[i][j]);
                    if (j == border0) {  // 触发边界
                        status = 1;
                        border0--;  // 状态改变，边界随之发生改变
                        i++;
                        break;
                    }
                    j++;
                    break;
                }
                case 1: {
                    result.add(matrix[i][j]);
                    if (i == border1) {
                        status = 2;
                        border1--;
                        j--;
                        break;
                    }
                    i++;
                    break;
                }
                case 2: {
                    result.add(matrix[i][j]);
                    if (j == border2) {
                        status = 3;
                        border2++;
                        i--;
                        break;
                    }
                    j--;
                    break;
                }
                case 3: {
                    result.add(matrix[i][j]);
                    if (i == border3) {
                        status = 0;
                        border3++;
                        j++;
                        break;
                    }
                    i--;
                    break;
                }
                default:
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}