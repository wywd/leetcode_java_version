/**
给定一个二叉树，返回它的 后序 遍历。 

 示例: 

 输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1] 

 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
 Related Topics 栈 树 深度优先搜索 二叉树 👍 697 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new L_145_BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        traversal(root, res);
        traversalWithStack(root, res);
        return res;
    }

    void traversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            traversal(node.left, res);
            traversal(node.right, res);
            res.add(node.val);
        }
    }

    // 后序：左右中： 中左右-> 中右左 -> 左右中
    void traversalWithStack(TreeNode node, List<Integer> res) {
        if (node == null) return;
        Deque<TreeNode> workStack = new LinkedList<>();
        workStack.offerFirst(node);
        TreeNode curNode;
        while (!workStack.isEmpty()) {
            curNode = workStack.pollFirst();
            res.add(curNode.val);
            if (curNode.left != null) {
                workStack.offerFirst(curNode.left);
            }
            if (curNode.right != null) {
                workStack.offerFirst(curNode.right);
            }
        }
        Collections.reverse(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}