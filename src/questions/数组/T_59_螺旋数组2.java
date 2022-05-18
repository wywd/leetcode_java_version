package questions.数组;

// https://leetcode-cn.com/problems/spiral-matrix-ii/

public class T_59_螺旋数组2 {
    public static void main(String[] args) {

    }

    // 这里采用的是状态模拟法，还可以使用按层的模拟法
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int state = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            if (state == 0) {
                if (y + 1 == n || res[x][y + 1] > 0) {
                    state = 1;
                    x++;
                } else {
                    y++;
                }
            } else if (state == 1) {
                if (x + 1 == n || res[x + 1][y] > 0) {
                    state = 2;
                    y--;
                } else {
                    x++;
                }
            } else if (state == 2) {
                if (y == 0 || res[x][y - 1] > 0) {
                    state = 3;
                    x--;
                } else {
                    y--;
                }
            } else {
                if (x == 0 || res[x - 1][y] > 0) {
                    state = 0;
                    y++;
                } else {
                    x--;
                }
            }
        }
        return res;
    }
}
