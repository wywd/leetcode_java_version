package questions.数学题;

//给你一个非负整数 x ，计算并返回x的 算术平方根 。
//        由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//示例 1：
//        输入：x = 4
//        输出：2
//示例 2：
//        输入：x = 8
//        输出：2
//        解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。



public class T_69_x的平方根 {
    public static void main(String[] args) {

    }

    // 方法1：二分查找法
    public int mySqrt1(int x) {
        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    // 方法2：牛顿迭代法
    // https://baike.baidu.com/item/牛顿迭代法
    public int mySqrt2(int x) {
        if (x == 0) {
            return x;
        }
        double C = x;
        double x0 = x;
        while (true) {
            double x1 = 0.5 * (x0 + C / x0);
            if (x0 - x1 < 1e-7) {
                break;
            }
            x0 = x1;
        }
        return (int) x0;
    }
}
