/**
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 

 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 

 
 
 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 

 

 示例 1： 

 
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
 

 示例 2： 

 
输入：n = 1
输出：[["Q"]]
 

 

 提示： 

 
 1 <= n <= 9 
 
 
 
 Related Topics 数组 回溯 👍 1156 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class L_51_NQueens {
    public static void main(String[] args) {
        Solution solution = new L_51_NQueens().new Solution();
        System.out.println(solution.solveNQueens(9).size());
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] chessboard = new int[n][n]; // 初始化都是0
        helper(chessboard, 0, n);
        return res;
    }

    void helper(int[][] chessboard, int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (chessboard[i][j] == 0) {
                        s.append(".");
                    } else {
                        s.append("Q");
                    }
                }
                temp.add(s.toString());
            }
            res.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {  // 这里的逻辑还没写对，就是如何正确地进行回溯
            if (isValid(chessboard, row, col, n)) {
                chessboard[row][col] = 1;
                helper(chessboard, row+1, n);
                chessboard[row][col] = 0;
            }
        }

    }

    private boolean isValid(int[][] chessboard, int row, int col, int n) {  // 判断当前行curIndex是否合法
        // 检查同一列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 1) {
                return false;
            }
        }

        // 检查45度角的斜线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        // 检查135度角的斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}