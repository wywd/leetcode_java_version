/**
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 

 如果可以，返回 true ；否则返回 false 。 

 magazine 中的每个字符只能在 ransomNote 中使用一次。 

 

 示例 1： 

 
输入：ransomNote = "a", magazine = "b"
输出：false
 

 示例 2： 

 
输入：ransomNote = "aa", magazine = "ab"
输出：false
 

 示例 3： 

 
输入：ransomNote = "aa", magazine = "aab"
输出：true
 

 

 提示： 

 
 1 <= ransomNote.length, magazine.length <= 10⁵ 
 ransomNote 和 magazine 由小写英文字母组成 
 
 Related Topics 哈希表 字符串 计数 👍 276 👎 0

*/

package leetcode.editor.cn;

public class L_383_RansomNote {
    public static void main(String[] args) {
        Solution solution = new L_383_RansomNote().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length();
        int len2 = ransomNote.length();
        if (len1 > len2) {
            return false;
        }
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        int[] count = new int[26];
        for (char c: str1) {
            count[c - 'a']++;
        }
        for (char c: str2) {
            if (count[c - 'a'] > 0) {
                count[c - 'a']--;
            }
        }
        for (int n: count) {
            if (n > 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}