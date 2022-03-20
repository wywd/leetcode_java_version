/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 

 有效字符串需满足： 

 
 左括号必须用相同类型的右括号闭合。 
 左括号必须以正确的顺序闭合。 
 

 

 示例 1： 

 
输入：s = "()"
输出：true
 

 示例 2： 

 
输入：s = "()[]{}"
输出：true
 

 示例 3： 

 
输入：s = "(]"
输出：false
 

 示例 4： 

 
输入：s = "([)]"
输出：false
 

 示例 5： 

 
输入：s = "{[]}"
输出：true 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 仅由括号 '()[]{}' 组成 
 
 Related Topics 栈 字符串 👍 2987 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class L_20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new L_20_ValidParentheses().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
                stack.offerLast(str[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pollLast();
                if (str[i] == ')' && c != '(' ||
                        str[i] == ']' && c != '[' ||
                        str[i] == '}' && c != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}