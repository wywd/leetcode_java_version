package questions.二叉树;

// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
// https://leetcode.cn/problems/symmetric-tree/

public class T_101_对称二叉树 {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
}
