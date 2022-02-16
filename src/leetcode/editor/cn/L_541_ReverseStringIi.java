/**
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 

 
 如果剩余字符少于 k 个，则将剩余字符全部反转。 
 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
 

 

 示例 1： 

 
输入：s = "abcdefg", k = 2
输出："bacdfeg"
 

 示例 2： 

 
输入：s = "abcd", k = 2
输出："bacd"
 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 仅由小写英文组成 
 1 <= k <= 10⁴ 
 
 Related Topics 双指针 字符串 👍 251 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L_541_ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new L_541_ReverseStringIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] str = s.toCharArray();
        int start = 0;
        while (start < len) {
            int left = start;
            int right = start + k - 1;
            if (right >= len) {
                right = len - 1;
            }
            while (left < right) {
                char temp = str[left];
                str[left++] = str[right];
                str[right--] = temp;
            }
            start += 2 * k;
        }
        return new String(str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}