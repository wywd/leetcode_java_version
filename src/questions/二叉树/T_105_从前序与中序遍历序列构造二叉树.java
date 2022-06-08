package questions.二叉树;

// 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.Arrays;
import java.util.HashMap;

public class T_105_从前序与中序遍历序列构造二叉树 {
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

    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, int[] inorder, int b1, int e1, int b2, int e2) {
        if (b1 > e1 || b2 > e2) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[b1]);
        if (b1 == e1) {
            return node;
        }
//        int index = find(inorder, preorder[b1]);
        int index = map.get(preorder[b1]);
        int size = index - b2;
        int ne1 = b1 + size;
        node.left = helper(preorder, inorder, b1 + 1, ne1, b2, index - 1);
        node.right = helper(preorder, inorder, ne1 + 1, e1, index + 1, e2);
        return node;
    }

    int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
