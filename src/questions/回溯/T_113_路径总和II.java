package questions.回溯;

import java.util.ArrayList;
import java.util.List;

public class T_113_路径总和II {
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

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        path.add(root.val);
        helper(root, targetSum - root.val);
        return res;
    }

    void helper(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, targetSum - root.left.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, targetSum - root.right.val);
            path.remove(path.size() - 1);
        }
    }
}
