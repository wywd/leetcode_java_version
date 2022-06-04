package questions.动态规划;

// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
// https://leetcode.cn/problems/unique-binary-search-trees/

public class T_96_不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(new T_96_不同的二叉搜索树().numTrees(3));
    }
    // 动态规划的思路
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
