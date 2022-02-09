/**
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 

 回文字符串 是正着读和倒过来读一样的字符串。 

 子字符串 是字符串中的由连续字符组成的一个序列。 

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 

 

 示例 1： 

 
输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
 

 示例 2： 

 
输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 由小写英文字母组成 
 
 Related Topics 字符串 动态规划 👍 774 👎 0

*/

package leetcode.editor.cn;

public class L_647_PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new L_647_PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("abccdcacdb"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {  // 没思路，还要加强字符串相关的题目训练！
    public int countSubstrings(String s) {
        int len, res = 0;
        if (s == null || (len = s.length()) < 1) {
            return 0;
        }
//        // 动态规划
//        //dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
//        boolean[][] dp = new boolean[len][len];  // 默认初始化为false
//        for (int i = len - 1; i >= 0; i--) {
//            for (int j = i; j < len; j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    if (j - i <= 1) {
//                        res++;
//                        dp[i][j] = true;
//                    } else if (dp[i+1][j-1]) {
//                        res++;
//                        dp[i][j] = true;
//                    }
//                }
//            }
//        }
        // 双指针：中心扩散法
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //如果当前是一个回文串，则记录数量
                res++;
                left--;
                right++;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}