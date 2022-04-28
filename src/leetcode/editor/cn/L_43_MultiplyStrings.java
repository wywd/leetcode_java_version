/**
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 

 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 

 

 示例 1: 

 
输入: num1 = "2", num2 = "3"
输出: "6" 

 示例 2: 

 
输入: num1 = "123", num2 = "456"
输出: "56088" 

 

 提示： 

 
 1 <= num1.length, num2.length <= 200 
 num1 和 num2 只能由数字组成。 
 num1 和 num2 都不包含任何前导零，除了数字0本身。 
 
 Related Topics 数学 字符串 模拟 👍 909 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_43_MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new L_43_MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123", "456"));
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{1, 2});
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int cur = len1 - 1 - i;
            int carry = 0;
            int a = c1[i] - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int b = c2[j] - '0';
                int v = a * b + carry + res[cur];
                res[cur] = v % 10;
                cur++;
                carry = v / 10;
            }
            res[cur] = carry;
        }
        StringBuilder sb = new StringBuilder();
        int p = res.length - 1;
        while (res[p] == 0) {
            p--;
        }
        while (p >= 0) {
            sb.append((char)(res[p] + '0'));
            p--;
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}