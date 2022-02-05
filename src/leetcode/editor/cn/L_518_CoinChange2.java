/**
给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 

 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 

 假设每一种面额的硬币有无限个。 

 题目数据保证结果符合 32 位带符号整数。 

 

 
 

 示例 1： 

 
输入：amount = 5, coins = [1, 2, 5]
输出：4
解释：有四种方式可以凑成总金额：
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 

 示例 2： 

 
输入：amount = 3, coins = [2]
输出：0
解释：只用面额 2 的硬币不能凑成总金额 3 。
 

 示例 3： 

 
输入：amount = 10, coins = [10] 
输出：1
 

 

 提示： 

 
 1 <= coins.length <= 300 
 1 <= coins[i] <= 5000 
 coins 中的所有值 互不相同 
 0 <= amount <= 5000 
 
 Related Topics 数组 动态规划 👍 709 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_518_CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new L_518_CoinChange2().new Solution();
        System.out.println(solution.change(5, new int[]{1,2,5}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
//        int[] dp = new int[amount+1];
//        dp[0] = 1;  // 关键，表示amount为0的时候，有几种组合方式，应该初始化为1，表示空集这种选择方式
//        for (int coin: coins) {  // 重量
//            for (int j = coin; j <= amount; j++) {  // 背包
//                // 分为不使用当前coin（旧值）和至少使用一个coin的情况（j-coin），j递增（区别0-1背包）保证了是至少
//                dp[j] += dp[j - coin];
//            }
//        }
//        return dp[amount];
        int[][] dp = new int[coins.length + 1][amount+1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 不使用该硬币的可能情况：
                dp[i][j] = dp[i - 1][j];
                // 使用该硬币：由于每个硬币可以被选择多次（容量允许的情况下），因此方案数量应当是选择「任意个」该硬币的方案总和：
                for (int k = 1; k  * coins[i-1] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}