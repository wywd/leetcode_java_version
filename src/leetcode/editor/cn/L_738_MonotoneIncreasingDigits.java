/**
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 

 （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 

 示例 1: 

 输入: N = 10
输出: 9
 

 示例 2: 

 输入: N = 1234
输出: 1234
 

 示例 3: 

 输入: N = 332
输出: 299
 

 说明: N 是在 [0, 10^9] 范围内的一个整数。 
 Related Topics 贪心 数学 👍 224 👎 0

*/

package leetcode.editor.cn;

public class L_738_MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new L_738_MonotoneIncreasingDigits().new Solution();
        System.out.println(solution.monotoneIncreasingDigits(18334));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {  // 太难了
    public int monotoneIncreasingDigits(int n) { // 18334
        if (n < 10) {
            return n;
        }
        char[] chars = Integer.toString(n).toCharArray();
        int start = Integer.MAX_VALUE;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i-1]) {
                chars[i] = '9';
                chars[i-1]--;
                start = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] == '0') { // 防止出现'09'的情况
                continue;
            }
            if (i >= start) {
                sb.append('9');
            } else {
                sb.append(chars[i]);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}