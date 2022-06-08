package questions.回溯;

// 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
// https://leetcode.cn/problems/path-sum-iii/

import java.util.HashMap;

public class T_437_路径总和_III {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//    int res = 0;
//    public int pathSum(TreeNode root, int targetSum) {
//        traversal(root, targetSum);
//        return res;
//    }
//
//    void traversal(TreeNode root, int targetSum) {
//        if (root == null) {
//            return;
//        }
//        helper(root, targetSum - root.val);
//        traversal(root.left, targetSum);
//        traversal(root.right, targetSum);
//    }
//
//    void helper(TreeNode root, int targetSum) {
//        if (targetSum == 0) {
//            res++;
//        }
//        if (root.left != null) {
//            helper(root.left, targetSum - root.left.val);
//        }
//        if (root.right != null) {
//            helper(root.right, targetSum - root.right.val);
//        }
//    }

    // 前缀和来减少重复计算，时间复杂度降低到o(N)，空间复杂度o(N)
    // https://leetcode.cn/problems/path-sum-iii/solution/tong-ge-lai-shua-ti-la-qian-zhui-he-tu-j-trcq/
    HashMap<Integer, Integer> map = new HashMap<>();
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0, 1);
        helper(root, 0, targetSum);
        return res;
    }

    void helper(TreeNode root, int curSum, int targetSum) {
        if (root == null) {
            return;
        }

        curSum += root.val;
        res += map.getOrDefault(curSum - targetSum, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        helper(root.left, curSum, targetSum);
        helper(root.right, curSum, targetSum);

        // 回溯。恢复状态
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
    }



}
