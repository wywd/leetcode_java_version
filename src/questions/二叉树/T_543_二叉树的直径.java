package questions.二叉树;

// 给定一棵二叉树，你需要计算它的直径长度。
// 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
// 这条路径可能穿过也可能不穿过根结点。
// https://leetcode.cn/problems/diameter-of-binary-tree/

public class T_543_二叉树的直径 {
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

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    int helper(TreeNode root) {  // 后序遍历
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
}
