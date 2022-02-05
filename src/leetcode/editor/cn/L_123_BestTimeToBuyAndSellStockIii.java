/**
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

 

 示例 1: 

 
输入：prices = [3,3,5,0,0,3,1,4]
输出：6
解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 

 示例 2： 

 
输入：prices = [1,2,3,4,5]
输出：4
解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 

 示例 3： 

 
输入：prices = [7,6,4,3,1] 
输出：0 
解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 

 示例 4： 

 
输入：prices = [1]
输出：0
 

 

 提示： 

 
 1 <= prices.length <= 10⁵ 
 0 <= prices[i] <= 10⁵ 
 
 Related Topics 数组 动态规划 👍 995 👎 0

*/

package leetcode.editor.cn;

public class L_123_BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new L_123_BestTimeToBuyAndSellStockIii().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {  // hard难度
    // 还是动态规划，先搞清楚有哪些状态，然后搞清楚状态怎么变化的（也就是递推公式），然后还要确定初始状况，最后确定遍历顺序
    public int maxProfit(int[] prices) {
//        if (prices.length == 1) {
//            return 0;
//        }
//        int[][] dp = new int[prices.length][5];  // 状态没有操作，第一次买入，第一次卖出，第二次买入，第二次卖出
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        dp[0][2] = 0;
//        dp[0][3] = -prices[0];
//        dp[0][4] = 0;
//        for (int i = 1; i < prices.length; i++) {
//            // 第一次买入状态，分为：是今天买入的，之前也已经买入了并且维持
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
//            // 第一次卖出状态
//            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]+prices[i]);
//            // 第二次买入状态
//            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]-prices[i]);
//            // 第二次卖出状态
//            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3]+prices[i]);
//        }
//        return Math.max(dp[prices.length-1][2], dp[prices.length-1][4]);
//    }
        // 空间优化
        if (prices.length == 1) {
            return 0;
        }
        int[] dp = new int[5];  // 状态没有操作，第一次买入，第一次卖出，第二次买入，第二次卖出
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;
        dp[3] = -prices[0];
        dp[4] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第一次买入状态，分为：是今天买入的，之前也已经买入了并且维持
            dp[1] = Math.max(dp[1], dp[0]-prices[i]);
            // 第一次卖出状态
            dp[2] = Math.max(dp[2], dp[1]+prices[i]);
            // 第二次买入状态
            dp[3] = Math.max(dp[3], dp[2]-prices[i]);
            // 第二次卖出状态
            dp[4] = Math.max(dp[4], dp[3]+prices[i]);
        }
        return Math.max(dp[2], dp[4]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}