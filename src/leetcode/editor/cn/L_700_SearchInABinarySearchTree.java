/**
给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 

 例如， 

 
给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和值: 2
 

 你应该返回如下子树: 

 
      2     
     / \   
    1   3
 

 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
 Related Topics 树 二叉搜索树 二叉树 👍 168 👎 0

*/

package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.TreeMap;

public class L_700_SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new L_700_SearchInABinarySearchTree().new Solution();
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

//二叉搜索树具有下列性质：
// 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
// 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}