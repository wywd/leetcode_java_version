package questions.数学题;

//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//进阶：不要 使用任何内置的库函数，如  sqrt 。

//示例 1：
//        输入：num = 16
//        输出：true
//示例 2：
//        输入：num = 14
//        输出：false
// https://leetcode-cn.com/problems/valid-perfect-square/


public class T_367_有效的完全平方数 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare2(16));
    }

    // 牛顿法思路
    public static boolean isPerfectSquare(int num) {
        double C = num;
        double x0 = num;
        while (true) {
            double x1 = 0.5 * (x0 + C / x0);
            if (x0 - x1 < 1e-7) {
                break;
            }
            x0 = x1;
        }
        int res = (int) x0;
        return res * res == num;
    }

    // 二分法思路
    public static boolean isPerfectSquare2(int num) {
        int left = 0;
        int right = num;
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= num) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res * res == num;
    }
}
