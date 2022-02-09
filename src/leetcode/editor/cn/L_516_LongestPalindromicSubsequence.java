/**
给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 

 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 

 

 示例 1： 

 
输入：s = "bbbab"
输出：4
解释：一个可能的最长回文子序列为 "bbbb" 。
 

 示例 2： 

 
输入：s = "cbbd"
输出：2
解释：一个可能的最长回文子序列为 "bb" 。
 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 仅由小写英文字母组成 
 
 Related Topics 字符串 动态规划 👍 718 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new L_516_LongestPalindromicSubsequence().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        char[] str = s.toCharArray();

        // 动态规划
        // dp[i][j]表示i到j的字符串最长回文序列长度
        int[][] dp = new int[len][len];
        dp[len - 1][len - 1] = 1;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (str[i] == str[j]) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (j - i <= 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

//        for (int i = 0; i < len; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[0][len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}