/**
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 

 

 示例： 
二叉树：[3,9,20,null,null,15,7], 

 
    3
   / \
  9  20
    /  \
   15   7
 

 返回其层序遍历结果： 

 
[
  [3],
  [9,20],
  [15,7]
]
 
 Related Topics 树 广度优先搜索 二叉树 👍 1057 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new L_102_BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        TreeNode curNode;
        while (!queue.isEmpty()) {
            int size = queue.size();   // 这里的size就是每一层的大小
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
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}