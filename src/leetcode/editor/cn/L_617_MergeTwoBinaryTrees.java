/**
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 

 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。 


 示例 1: 

 
输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

 注意: 合并必须从两个树的根节点开始。 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 809 👎 0

*/

package leetcode.editor.cn;

public class L_617_MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new L_617_MergeTwoBinaryTrees().new Solution();
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    	if (root1 == null && root2 == null) return null;  // 如果两个节点都为空
    	else if (root1 != null && root2 == null) return root1;  // 如果只有root1不为空，直接返回root1
    	else if (root1 == null) return root2;  // 如果只有节点2不为空，直接返回root2
    	else {  // 它们都不为空
    		TreeNode root = new TreeNode(root1.val + root2.val);
    		root.left = mergeTrees(root1.left, root2.left);
    		root.right = mergeTrees(root1.right, root2.right);
    		return root;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}