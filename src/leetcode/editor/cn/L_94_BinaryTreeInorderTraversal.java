/**
给定一个二叉树的根节点 root ，返回它的 中序 遍历。 

 

 示例 1： 

 
输入：root = [1,null,2,3]
输出：[1,3,2]
 

 示例 2： 

 
输入：root = []
输出：[]
 

 示例 3： 

 
输入：root = [1]
输出：[1]
 

 示例 4： 

 
输入：root = [1,2]
输出：[2,1]
 

 示例 5： 

 
输入：root = [1,null,2]
输出：[1,2]
 

 

 提示： 

 
 树中节点数目在范围 [0, 100] 内 
 -100 <= Node.val <= 100 
 

 

 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
 Related Topics 栈 树 深度优先搜索 二叉树 👍 1140 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new L_94_BinaryTreeInorderTraversal().new Solution();
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        traversal(root, res);
        traversalWithStack(root, res);
        return res;
    }

    void traversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            traversal(node.left, res);
            res.add(node.val);
            traversal(node.right, res);
        }
    }


    // 栈的方式，和先序和后序的实现方式不统一
    void traversalWithStack(TreeNode node, List<Integer> res) {
        if (node == null) return;
        Deque<TreeNode> workStack = new LinkedList<>();
        TreeNode curNode = node;
        while (curNode != null || !workStack.isEmpty()) {
            if (curNode != null) {
                workStack.offerFirst(curNode);
                curNode = curNode.left;
            } else {
                curNode = workStack.pollFirst();
                res.add(curNode.val);
                curNode = curNode.right;
            }
        }
    }

    // 用栈实现遍历，且三种遍历方式统一代码风格
//    void traversalUniform(TreeNode node, List<Integer> res) {
//        if (node == null) return;
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)


}