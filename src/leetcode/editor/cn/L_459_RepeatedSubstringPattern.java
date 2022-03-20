/**
给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。 

 

 示例 1: 

 
输入: s = "abab"
输出: true
解释: 可由子串 "ab" 重复两次构成。
 

 示例 2: 

 
输入: s = "aba"
输出: false
 

 示例 3: 

 
输入: s = "abcabcabcabc"
输出: true
解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 

 

 提示： 

 

 
 1 <= s.length <= 10⁴ 
 s 由小写英文字母组成 
 
 Related Topics 字符串 字符串匹配 👍 617 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_459_RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new L_459_RepeatedSubstringPattern().new Solution();
        String s = "abac";
        int len2 = s.length();
        char[] t = s.toCharArray();
        // 先求next数组
        int[] next = new int[len2];
        int j = -1;
        int i = 1;
        next[0] = -1;
        while (i < len2) {
            while (j >= 0 && t[i] != t[j + 1]) {
                j = next[j];
            }
            if (t[i] == t[j+1]) {
                j++;
            }
            next[i] = j;
            i++;
        }
        System.out.println(Arrays.toString(next));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}