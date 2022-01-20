/**
给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 

 

 示例 1: 

 
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
 

 示例 2: 

 
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

 

 提示: 

 
 1 <= preorder.length <= 3000 
 inorder.length == preorder.length 
 -3000 <= preorder[i], inorder[i] <= 3000 
 preorder 和 inorder 均无重复元素 
 inorder 均出现在 preorder 
 preorder 保证为二叉树的前序遍历序列 
 inorder 保证为二叉树的中序遍历序列 
 
 Related Topics 树 数组 哈希表 分治 二叉树 👍 1303 👎 0

*/

package leetcode.editor.cn;

import java.util.HashMap;

public class L_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new L_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] inorder = new int[]{11, 9, 16, 3, 15, 20, 7};
        int[] preorder = new int[]{3, 9, 11, 16, 20, 15, 7};
        solution.buildTree(preorder, inorder);

    }
    public class TreeNode {
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
    private int[] inorder;  // 中序
    private int[] preorder;  // 前序
    HashMap<Integer, Integer> nodeMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            nodeMap.put(inorder[i], i);
        }
        return _buildTree(0, preorder.length, 0, inorder.length);
    }

    public TreeNode _buildTree(int b1, int e1, int b2, int e2) {
        int length = e2 - b2;
        if (length == 0) return null;
        if (length == 1) {
            return new TreeNode(this.inorder[b2]);
        }
        TreeNode root = new TreeNode(this.preorder[b1]);
        int pos = this.nodeMap.get(this.preorder[b1]);
        int pos2 = b1 + pos - b2 + 1;
        root.left = _buildTree(b1+1, pos2, b2, pos);
        root.right = _buildTree(pos2, e1, pos + 1, e2);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}