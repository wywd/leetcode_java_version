package questions.二叉树;

// 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
// （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[3],[20,9],[15,7]]
// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/


import java.util.*;

public class T_103_二叉树的锯齿形层序遍历 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (isOrderLeft) {
                    deque.offerLast(node.val);
                } else {
                    deque.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
            res.add(new ArrayList<>(deque));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
