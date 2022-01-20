/**
给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 

 假设二叉树中至少有一个节点。 

 

 示例 1: 

 

 
输入: root = [2,1,3]
输出: 1
 

 示例 2: 

 

 
输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
 

 

 提示: 

 
 二叉树的节点个数的范围是 [1,10⁴] 
 -2³¹ <= Node.val <= 2³¹ - 1 
 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 217 👎 0

*/

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class L_513_FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new L_513_FindBottomLeftTreeValue().new Solution();
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
class Solution {  // 这里用了层次遍历，递归回溯的方法后面再考虑
    public int findBottomLeftValue(TreeNode root) {
        int curLeftValue = -1;
        Deque<TreeNode> workStack = new LinkedList<>();
        workStack.offerLast(root);
        while (!workStack.isEmpty()) {
            int size = workStack.size();
            TreeNode curNode = workStack.pollFirst();
            curLeftValue = curNode.val;
            if (curNode.left != null) workStack.offerLast(curNode.left);
            if (curNode.right != null) workStack.offerLast(curNode.right);
            for (int i = 1; i < size; i++) {
                curNode = workStack.pollFirst();
                if (curNode.left != null) workStack.offerLast(curNode.left);
                if (curNode.right != null) workStack.offerLast(curNode.right);
            }
        }
        return curLeftValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}