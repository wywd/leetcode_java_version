package questions.二叉树;

// 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
// https://leetcode.cn/problems/binary-tree-right-side-view/

import java.util.ArrayList;
import java.util.List;

public class T_199_二叉树的右视图 {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    void helper(TreeNode root, List<Integer> res, int height) {  // 中-右-左 的顺序递归遍历
        if (root == null) {
            return;
        }
        if (res.size() == height) {  // 说明这个root目前位于最右边
            res.add(root.val);
        }
        helper(root.right, res, height + 1);
        helper(root.left, res, height + 1);
    }

    // 当然也可以采用层次遍历+队列的方式
}
