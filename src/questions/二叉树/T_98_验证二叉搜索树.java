package questions.二叉树;

// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
// https://leetcode.cn/problems/validate-binary-search-tree/

public class T_98_验证二叉搜索树 {
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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        return res;
    }

    // 中序遍历
    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!res) {  // 剪枝
            return;
        }
        traversal(root.left);

        if (prev != null) {
            if (root.val <= prev.val) {
                res = false;
            }
        }
        prev = root;

        traversal(root.right);
    }


    // 一种更简单的方法
    TreeNode pre = null;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST2(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST2(root.right);
    }
}
