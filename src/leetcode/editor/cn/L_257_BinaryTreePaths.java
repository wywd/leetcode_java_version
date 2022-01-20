/**
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 

 叶子节点 是指没有子节点的节点。 
 

 示例 1： 

 
输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
 

 示例 2： 

 
输入：root = [1]
输出：["1"]
 

 

 提示： 

 
 树中节点的数目在范围 [1, 100] 内 
 -100 <= Node.val <= 100 
 
 Related Topics 树 深度优先搜索 字符串 二叉树 👍 596 👎 0

*/

package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.*;

public class L_257_BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new L_257_BinaryTreePaths().new Solution();
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
class Solution {  // 这道题花了我很长时间，后面需要好好看看
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        // 叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}