/**
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 

 假定 BST 有如下定义： 

 
 结点左子树中所含结点的值小于等于当前结点的值 
 结点右子树中所含结点的值大于等于当前结点的值 
 左子树和右子树都是二叉搜索树 
 

 例如： 
给定 BST [1,null,2,2], 

    1
    \
     2
    /
   2
 

 返回[2]. 

 提示：如果众数超过1个，不需考虑输出顺序 

 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 376 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_501_FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new L_501_FindModeInBinarySearchTree().new Solution();
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
    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        int maxCount = 0;
        int count = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                if (pre == null ) {  // 第一个元素
                    count = 1;
                } else if (cur.val == pre.val) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == maxCount) {
                    res.add(cur.val);
                }
                if (count > maxCount) {
                    res.clear();
                    res.add(cur.val);
                    maxCount = count;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}