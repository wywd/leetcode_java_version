package questions.二叉树;

// 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
// 例如:
// 给定的树 A:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
// 给定的树 B：
//
//   4
//  /
// 1
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
// https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/

public class 剑指_Offer_26_树的子结构 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val != B.val) {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        } else {
            return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        } else {
            return helper(A.left, B.left) && helper(A.right, B.right);
        }
    }
}
