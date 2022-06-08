package questions.二叉树;

// 给定一个二叉树，判断它是否是高度平衡的二叉树。
// 本题中，一棵高度平衡二叉树定义为：
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
// https://leetcode.cn/problems/balanced-binary-tree/

public class T_110_平衡二叉树 {
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

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }

    // 更好的思路：（剪枝）
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;
        return Math.abs(rightHeight - leftHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }

}
