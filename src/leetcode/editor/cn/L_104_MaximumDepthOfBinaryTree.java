/**
给定一个二叉树，找出其最大深度。 

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 

 说明: 叶子节点是指没有子节点的节点。 

 示例： 
给定二叉树 [3,9,20,null,null,15,7]， 

     3
   / \
  9  20
    /  \
   15   7 

 返回它的最大深度 3 。 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1009 👎 0

*/

package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

public class L_104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new L_104_MaximumDepthOfBinaryTree().new Solution();
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));  // 其实这是后序遍历的递归方式
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}

// 使用层序遍历，用队列来解决，这是最初的思路，因为比较直接
//    public int maxDepth(TreeNode root) {
//        int depth = 0;
//        if (root == null) return depth;
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offerLast(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            for (int i = 0; i < size; i++) {
//                TreeNode curNode = queue.pollFirst();
//                if (curNode.left != null) {
//                    queue.offerLast(curNode.left);
//                }
//                if (curNode.right != null) {
//                    queue.offerLast(curNode.right);
//                }
//            }
//        }
//        return depth;
//    }