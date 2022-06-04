package questions.二叉树;

// 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
// 可以按 任意顺序 返回答案。
// https://leetcode.cn/problems/unique-binary-search-trees-ii/



import java.util.ArrayList;
import java.util.List;

public class T_95_不同的二叉搜索树II {
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

    // 递归的思路
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {  // 分别选择1-n为根节点，递归其左右子树
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);
            for (TreeNode left: leftTrees) {  // 进行组合
                for (TreeNode right: rightTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
