/**
给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 

 例如： 
给定二叉树 [3,9,20,null,null,15,7], 

 
    3
   / \
  9  20
    /  \
   15   7
 

 返回其自底向上的层序遍历为： 

 
[
  [15,7],
  [9,20],
  [3]
]
 
 Related Topics 树 广度优先搜索 二叉树 👍 499 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_107_BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new L_107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {  // 相比较于102，反转一下res数组就好了
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        TreeNode curNode;
        while (!queue.isEmpty()) {
            int size = queue.size();  // 这里的size就是每一层的大小
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                curNode = queue.pollFirst();
                tmp.add(curNode.val);
                if (curNode.left != null) {
                    queue.offerLast(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offerLast(curNode.right);
                }
            }
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}