/**
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 

 

 示例 1： 

 输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 

 

 提示： 

 
 节点值的范围在32位有符号整数范围内。 
 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 293 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_637_AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new L_637_AverageOfLevelsInBinaryTree().new Solution();
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
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
            double v = 0;
            for (int i = 0; i < size; i++) {
                v += tmp.get(i);
            }
            res.add(v/size);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}