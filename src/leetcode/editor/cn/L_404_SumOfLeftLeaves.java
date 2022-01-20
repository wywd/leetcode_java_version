/**
计算给定二叉树的所有左叶子之和。 

 示例： 

 
    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 

 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 361 👎 0

*/

package leetcode.editor.cn;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class L_404_SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new L_404_SumOfLeftLeaves().new Solution();
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        getLeftLeafValue(root, values, false);
        int sum = 0;
        for (int v: values) {
            sum += v;
        }
        return sum;
    }

    private void getLeftLeafValue(TreeNode root, List<Integer> values, boolean isLeft) {
        if (root.left == null && root.right == null && isLeft) {
            values.add(root.val);
        }
        if (root.left != null) {
            getLeftLeafValue(root.left, values, true);
        }
        if (root.right != null) {
            getLeftLeafValue(root.right, values, false);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}