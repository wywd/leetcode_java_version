package questions.二叉树;

// https://leetcode.cn/problems/binary-tree-inorder-traversal/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T_94_二叉树的中序遍历 {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        traversal(root, res);
        traversal2(root, res);
        return res;
    }

    // 方式一：递归
    void traversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traversal(root.left, res);

        // 中序遍历，所以在中间处理当前节点
        res.add(root.val);

        traversal(root.right, res);
    }

    // 方式二：迭代
    void traversal2(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        TreeNode cur = root.left;
        while (!stack.isEmpty() && cur != null) {
            while (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            res.add(cur.val);
            cur = cur.right;
        }
    }
}
