/**
给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。 

 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

 

 示例 1: 

 
输入: prices = [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 

 示例 2: 

 
输入: prices = [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 

 示例 3: 

 
输入: prices = [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 

 

 提示： 

 
 1 <= prices.length <= 3 * 10⁴ 
 0 <= prices[i] <= 10⁴ 
 
 Related Topics 贪心 数组 动态规划 👍 1533 👎 0

*/

package leetcode.editor.cn;


public class L_122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new L_122_BestTimeToBuyAndSellStockIi().new Solution();
        System.out.println(solution.maxProfit(new int[]{2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        // 贪心1
//        int res = 0;
//        int pre = 0;
//        int cur = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < prices[cur]) {
//                res += prices[cur] - prices[pre];
//                pre = i;
//            }
//            cur = i;
//        }
//        res += prices[cur] - prices[pre];
//        return res;
        // 更简单的思路（贪心2）：
//        int res = 0;
//        for (int i = 1; i < prices.length; i++) {
//            res += Math.max(prices[i] - prices[i-1], 0);
//        }
//        return res;
        // 动态规划
//        if (prices.length == 1) {
//            return 0;
//        }
////        dp[i][0] 表示第i天持有股票所得现金。
////        dp[i][1] 表示第i天不持有股票所得最多现金
//        int[][] dp = new int[prices.length][2];  // 第i天是否持有股票,位置0是持有股票，位置1是不持有股票，获得的最大收益
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < prices.length; i++) {
//            //第i天持有股票的最大收益，两种可能：之前就持有股票，之前不持有股票了今天买入的
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
//            //第i天不持有股票的最大收益，两种可能：之前就不持有股票，今天卖出的
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
//        }
//        return dp[prices.length-1][1];
        // 动态规划2-滚动数组[优化空间]
        if (prices.length == 1) {
            return 0;
        }
        int[] dp = new int[2];  // 第i天是否持有股票,位置0是持有股票，位置1是不持有股票，获得的最大收益
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天持有股票的最大收益，两种可能：之前就持有股票，之前不持有股票了今天买入的
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            //第i天不持有股票的最大收益，两种可能：之前就不持有股票，今天卖出的
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}