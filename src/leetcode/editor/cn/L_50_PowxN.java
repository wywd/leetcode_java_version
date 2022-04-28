/**
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。 

 

 示例 1： 

 
输入：x = 2.00000, n = 10
输出：1024.00000
 

 示例 2： 

 
输入：x = 2.10000, n = 3
输出：9.26100
 

 示例 3： 

 
输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
 

 

 提示： 

 
 -100.0 < x < 100.0 
 -231 <= n <= 231-1 
 -104 <= xⁿ <= 104 
 
 Related Topics 递归 数学 👍 942 👎 0

*/

package leetcode.editor.cn;

public class L_50_PowxN {
    public static void main(String[] args) {
        Solution solution = new L_50_PowxN().new Solution();
        System.out.println(solution.myPow(2, -2));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        int step = n;
        double res = 1;
        while (step > 0) {
            double temp = x;
            int begin = 1;
            while (2 * begin <= step) {
                temp = temp * temp;
                begin = begin * 2;
            }
            res = res * temp;
            step = step - begin;
        }
        if (flag) {
            return 1 / res;
        } else {
            return res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}