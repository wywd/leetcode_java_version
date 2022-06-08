package questions.二叉树;

public class T_236_二叉树的最近公共祖先 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    boolean helper(TreeNode root, TreeNode p, TreeNode q) {  // 首先这道题肯定得用后序遍历，这个得理解（这里使用了递归）
        if (root == null) {
            return false;
        }
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        if (left && right) {   // 要么左右子树中包含，并且这两个赋值之会发生一次
            res = root;
        }
        if (root == p || root == q) {
            if (left || right) {  // 要么该节点本身和某个子树包含
                res = root;
            }
            return true;
        }
        return left || right;
    }


    // 更好的思路，结合了前序遍历和后序遍历，
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 前序遍历，相当于正向找目标节点，如果找到，就不用去遍历它的子树了，直接返回该节点
        // 因为如果其子树中不包含另一个目标节点，一定会走最后一个if分支，如果包含了，那么该节点就是题目需要的
        // 所以相当于一个剪枝
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        // 后序遍历
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {  // 说明左右子树均包含目标节点
            return root;
        }
    }
}
