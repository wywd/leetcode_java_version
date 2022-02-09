/**
给定两个单词 word1 和 word2 ，返回使得 word1 和 word2 相同所需的最小步数。 

 每步 可以删除任意一个字符串中的一个字符。 

 

 示例 1： 

 
输入: word1 = "sea", word2 = "eat"
输出: 2
解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 

 示例 2: 

 
输入：word1 = "leetcode", word2 = "etco"
输出：4
 

 

 提示： 
 

 
 1 <= word1.length, word2.length <= 500 
 word1 和 word2 只包含小写英文字母 
 
 Related Topics 字符串 动态规划 👍 366 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_583_DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new L_583_DeleteOperationForTwoStrings().new Solution();
        System.out.println(solution.minDistance("ac", "cc"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 2, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }
        return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}