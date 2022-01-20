/**
给定一个二叉树，检查它是否是镜像对称的。 

 

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 

     1
   / \
  2   2
 / \ / \
3  4 4  3
 

 

 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 

     1
   / \
  2   2
   \   \
   3    3
 

 

 进阶： 

 你可以运用递归和迭代两种方法解决这个问题吗？ 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1581 👎 0

*/

package leetcode.editor.cn;


import java.util.Deque;
import java.util.LinkedList;

public class L_101_SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new L_101_SymmetricTree().new Solution();
        TreeNode node1 = new L_101_SymmetricTree().new TreeNode(3, null, null);
        TreeNode node2 = new L_101_SymmetricTree().new TreeNode(4, null, null);
        TreeNode node3 = new L_101_SymmetricTree().new TreeNode(4, null, null);
        TreeNode node4 = new L_101_SymmetricTree().new TreeNode(3, null, null);
        TreeNode node5 = new L_101_SymmetricTree().new TreeNode(2, null, node2);
        TreeNode node6 = new L_101_SymmetricTree().new TreeNode(2, null, node4);
        TreeNode root = new L_101_SymmetricTree().new TreeNode(2, node5, node6);
        boolean symmetric = solution.isSymmetric(root);
        System.out.println(symmetric);
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
    public boolean isSymmetric(TreeNode root) {  // 递归地方式，比较左右子树可否翻转，思路就很清晰！
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else if (left.val != right.val) return false;
        else return compare(left.left, right.right) && compare(left.right, right.left);  // 核心代码
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

// 最初的思路： 利用层次遍历来解决，但是比较复杂
//public boolean isSymmetric(TreeNode root) {
//    if (root == null) return true;
//    Deque<TreeNode> queue = new LinkedList<>();
//    queue.offerLast(root);
//    while (!queue.isEmpty()) {
//        int size = queue.size();
//        String[] values = new String[size];
//        for (int i = 0; i < size; i++) {
//            TreeNode curNode = queue.pollFirst();
//            if (curNode == null) {
//                values[i] = "null";
//            } else {
//                values[i] = String.valueOf(curNode.val);
//            }
//            // null 节点也保存
//            if (curNode != null) {
//                queue.offerLast(curNode.left);
//                queue.offerLast(curNode.right);
//            }
//
//        }
//        for (int i = 0; i < size/2; i++) {
//            if (!values[i].equals(values[size-1-i])) {
//                return false;
//            }
//        }
//    }
//    return true;
//}
