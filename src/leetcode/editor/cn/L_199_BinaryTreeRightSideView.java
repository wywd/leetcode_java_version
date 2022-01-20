/**
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 

 

 示例 1: 

 

 
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
 

 示例 2: 

 
输入: [1,null,3]
输出: [1,3]
 

 示例 3: 

 
输入: []
输出: []
 

 

 提示: 

 
 二叉树的节点个数的范围是 [0,100] 
 -100 <= Node.val <= 100 
 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 553 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_199_BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new L_199_BinaryTreeRightSideView().new Solution();
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        TreeNode curNode;
        while (!queue.isEmpty()) {
            int size = queue.size();   // 这里的size就是每一层的大小
            for (int i = 0; i < size; i++) {
                curNode = queue.pollFirst();
                if (i == size - 1) {
                    res.add(curNode.val);   // 就是每一层最后一个元素保存到res数组中
                }
                if (curNode.left != null) {
                    queue.offerLast(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offerLast(curNode.right);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}