/**
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 

 

 示例 1： 

 
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶 

 示例 2： 

 
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 

 

 提示： 

 
 1 <= n <= 45 
 
 Related Topics 记忆化搜索 数学 动态规划 👍 2147 👎 0

*/

package leetcode.editor.cn;

public class L_70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new L_70_ClimbingStairs().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
//        if (n < 4) {
//            return n;
//        }
//
//        int x1 = 2;
//        int x2 = 3;
//        int t;
//        for (int i = 4; i <= n; i++) {
//            t = x1 + x2;
//            x1 = x2;
//            x2 = t;
//        }
//        return x2;
        // 动规:排列问题
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i >= j) {
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}