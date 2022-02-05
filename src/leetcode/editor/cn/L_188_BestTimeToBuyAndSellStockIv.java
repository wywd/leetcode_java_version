/**
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

 

 示例 1： 

 
输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 

 示例 2： 

 
输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。 


 

 提示： 

 
 0 <= k <= 100 
 0 <= prices.length <= 1000 
 0 <= prices[i] <= 1000 
 
 Related Topics 数组 动态规划 👍 655 👎 0

*/

package leetcode.editor.cn;

public class L_188_BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new L_188_BestTimeToBuyAndSellStockIv().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
//        if (prices.length <= 1 || k == 0) {
//            return 0;
//        }
//        int[][] dp = new int[prices.length][2*k+1];  // 交易k次，总共2k+1种状态
//        dp[0][0] = 0;  // 还未操作的状态
//        for (int n = 1; n < dp[0].length; n++) {
//            if (n % 2 == 1) {  // 买入状态
//                dp[0][n] = -prices[0];
//            }
//        }
//        for (int i = 1; i < prices.length; i++) {
//            for (int n = 1; n < dp[i].length; n++) {
//                if (n % 2 == 1) {  // 买入状态
//                    dp[i][n] = Math.max(dp[i-1][n], dp[i-1][n-1] - prices[i]);
//                } else {  // 卖出状态
//                    dp[i][n] = Math.max(dp[i-1][n], dp[i-1][n-1] + prices[i]);
//                }
//            }
//        }
//        return dp[prices.length - 1][dp[0].length-1];
        // 优化空间
        if (prices.length <= 1 || k == 0) {
            return 0;
        }
        int[] dp = new int[2*k+1];  // 交易k次，总共2k+1种状态
        dp[0] = 0;  // 还未操作的状态
        for (int n = 1; n < dp.length; n++) {
            if (n % 2 == 1) {  // 买入状态
                dp[n] = -prices[0];
            }
        }
        for (int i = 1; i < prices.length; i++) {
            for (int n = 1; n < dp.length; n++) {
                if (n % 2 == 1) {  // 买入状态
                    dp[n] = Math.max(dp[n], dp[n-1] - prices[i]);
                } else {  // 卖出状态
                    dp[n] = Math.max(dp[n], dp[n-1] + prices[i]);
                }
            }
        }
        return dp[dp.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}