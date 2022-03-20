/**
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 

 你可以对一个单词进行如下三种操作： 

 
 插入一个字符 
 删除一个字符 
 替换一个字符 
 

 

 示例 1： 

 
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
 

 示例 2： 

 
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 

 

 提示： 

 
 0 <= word1.length, word2.length <= 500 
 word1 和 word2 由小写英文字母组成 
 
 Related Topics 字符串 动态规划 👍 2085 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class L_72_EditDistance {
    public static void main(String[] args) {
        Solution solution = new L_72_EditDistance().new Solution();
        System.out.println(solution.minDistance("zoologicoarchaeologist", "zoogeologist"));
//        System.out.println(solution.minDistance("zoolo", "zoo"));
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
//        System.out.print("\t");
//        System.out.print("\"\"\t");
//        for (int n = 0; n < len2; n++) {
//            System.out.print(word2.charAt(n) + "\t");
//        }
//        System.out.println();
//        System.out.print("\"\"\t");
//        for (int n = 0; n <= len2; n++) {
//            System.out.print(dp[0][n] + "\t");
//        }
//        System.out.println();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
//            System.out.print(word1.charAt(i - 1) + "\t");
//            for (int n = 0; n <= len2; n++) {
//                System.out.print(dp[i][n] + "\t");
//            }
//            System.out.println();
        }
        return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}