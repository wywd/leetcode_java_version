package questions.二叉树;

// 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
//
// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/

public class T_108_将有序数组转换为二叉搜索树 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, begin, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
