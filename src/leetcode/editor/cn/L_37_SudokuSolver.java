/**
编写一个程序，通过填充空格来解决数独问题。 

 数独的解法需 遵循如下规则： 

 
 数字 1-9 在每一行只能出现一次。 
 数字 1-9 在每一列只能出现一次。 
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
 

 数独部分空格内已填入了数字，空白格用 '.' 表示。 

 

 
 
 
 示例： 

 
输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",
".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".",
"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".
",".",".",".","8",".",".","7","9"]]
输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4
","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6
","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5
","2","8","6","1","7","9"]]
解释：输入的数独如上图所示，唯一有效的解决方案如下所示：


 

 

 提示： 

 
 board.length == 9 
 board[i].length == 9 
 board[i][j] 是一位数字或者 '.' 
 题目数据 保证 输入数独仅有一个解 
 
 
 
 
 Related Topics 数组 回溯 矩阵 👍 1095 👎 0

*/

package leetcode.editor.cn;

import java.text.Format;
import java.util.Arrays;

public class L_37_SudokuSolver {  // 二维空间的回溯，我直接把他变成一维的，变成N皇后了！
    public static void main(String[] args) {
        Solution solution = new L_37_SudokuSolver().new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '.'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("================================>");
        solution.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0);
    }

    boolean helper(char[][] board, int start) {
        if (start == 81) {  // 表示填写完了，返回结果
            return true;
        }
        int i = start / 9;  // 哪一行
        int j = start % 9;  // 哪一列
        if (board[i][j] == '.') {  // 如果当前位置需要填写数独
            for (char c = '1'; c <= '9'; c++) {  // 对于每一个可能的数字
                if (isValid(board, i, j, c)) {  // 如果合法
                    board[i][j] = c;
                    if (helper(board, start + 1) ){
                        return true;
                    }
                    board[i][j] = '.'; // 否则就回溯
                }
            }
            return false;
        } else {
            return helper(board, start + 1);
        }

    }

    // 判断当前位置填入这个值是否合法
    private boolean isValid(char[][] board, int row, int col, char c) {
        // 判断列
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == c) {
                return false;
            }
        }

        // 判断行
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == c) {
                return false;
            }
        }

        // 判断3×3宫格
        int x = row / 3 * 3;  // 我的错误竟然出自这里！
        int y = col / 3 * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (i != row || j != col) {
                    if (board[i][j] == c) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}