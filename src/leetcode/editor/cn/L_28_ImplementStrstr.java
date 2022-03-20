/**
实现 strStr() 函数。 

 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不
存在，则返回 -1 。 

 

 说明： 

 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 

 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 

 

 示例 1： 

 
输入：haystack = "hello", needle = "ll"
输出：2
 

 示例 2： 

 
输入：haystack = "aaaaa", needle = "bba"
输出：-1
 

 示例 3： 

 
输入：haystack = "", needle = ""
输出：0
 

 

 提示： 

 
 0 <= haystack.length, needle.length <= 5 * 10⁴ 
 haystack 和 needle 仅由小写英文字符组成 
 
 Related Topics 双指针 字符串 字符串匹配 👍 1260 👎 0

*/

package leetcode.editor.cn;

public class L_28_ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new L_28_ImplementStrstr().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0) {
            return 0;
        }
        if (len1 == 0 || len1 < len2) {
            return -1;
        }
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        // 先求next数组
        int[] next = new int[len2];
        int j = -1;
        int i = 0;
        next[0] = -1;
        while (i < len2 - 1) {
            if (j == -1 || t[j] == t[i]) {
                j++;
                i++;
                if (t[i] == t[j]) {
                    next[i] = next[j];
                } else {
                    next[i] = j;
                }
            } else {
                j = next[j];
            }
        }
        // 然后进行匹配
        i = 0;
        j = 0;
        while (i < len1 && j < len2) {
            if (j == - 1 || s[i] == t[j]) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}