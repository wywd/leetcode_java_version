/**
给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 

 
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
 

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

 

 示例 1: 

 
输入: prices = [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 

 示例 2: 

 
输入: prices = [1]
输出: 0
 

 

 提示： 

 
 1 <= prices.length <= 5000 
 0 <= prices[i] <= 1000 
 
 Related Topics 数组 动态规划 👍 1044 👎 0

*/

package leetcode.editor.cn;

public class L_309_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new L_309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {  // 有点难，主要是要区分两种卖出状态
    public int maxProfit(int[] prices) {
        int[] dp = new int[4]; // 状态：买入，今天卖出，冷冻期，冷冻期后的卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 需要使用临时变量
            int temp1 = dp[0];
            int temp2 = dp[1];
            // 买入 <- 买入，冷冻期，冷冻期后的卖出
            dp[0] = Math.max(Math.max(dp[0], dp[2]-prices[i]), dp[3]-prices[i]);
            // 今天卖出 <- 买入
            dp[1] = temp1 + prices[i];
            // 冷冻期 <- 今天卖出
            dp[2] = temp2;
            // 冷冻期后的卖出状态 <- 冷冻期后的卖出状态，冷冻期
            dp[3] = Math.max(dp[3], dp[2]);
        }
        return Math.max(Math.max(dp[1], dp[2]), dp[3]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}