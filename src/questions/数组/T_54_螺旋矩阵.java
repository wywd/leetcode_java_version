package questions.数组;

// 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
// https://leetcode.cn/problems/spiral-matrix/


import java.util.ArrayList;
import java.util.List;

public class T_54_螺旋矩阵 {
    public static void main(String[] args) {

    }

    // 这里是按层模拟法实现的，另外也可以采用状态模拟法
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while (n > 1 && m > 1) {
            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y]);
                y++;
            }
            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x][y]);
                x++;
            }
            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y]);
                y--;
            }
            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x][y]);
                x--;
            }
            x++;
            y++;
            n -= 2;
            m -= 2;
        }
        if (m == 1 && n == 1) {
            res.add(matrix[x][y]);
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                res.add(matrix[x][y]);
                y++;
            }
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                res.add(matrix[x][y]);
                x++;
            }
        }
        return res;
    }
}
