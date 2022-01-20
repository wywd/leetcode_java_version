/**
根据一棵树的中序遍历与后序遍历构造二叉树。 

 注意: 
你可以假设树中没有重复的元素。 

 例如，给出 

 中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3] 

 返回如下的二叉树： 

     3
   / \
  9  20
    /  \
   15   7
 
 Related Topics 树 数组 哈希表 分治 二叉树 👍 619 👎 0

*/

package leetcode.editor.cn;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

@Slf4j(topic = "c.L_106")
public class L_106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new L_106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = new int[]{11, 9, 16, 3, 15, 20, 7};
        int[] postorder = new int[]{11, 16, 9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
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
class Solution {  // 一个重要条件是：你可以假设树中没有重复的元素
    private int[] inorder;
    private int[] postorder;
    HashMap<Integer, Integer> nodeMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            nodeMap.put(inorder[i], i);
        }
        return _buildTree(0, inorder.length, 0, postorder.length);
    }

    public TreeNode _buildTree(int b1, int e1, int b2, int e2) {
        int length = e1 - b1;
        if (length == 0) return null;
        if (length == 1) {
            return new TreeNode(this.inorder[b1]);
        }
        TreeNode root = new TreeNode(this.postorder[e2 - 1]);
//        int pos = arraySearch(this.inorder, this.postorder[e2 - 1], b1, e1);
        int pos = this.nodeMap.get(this.postorder[e2 - 1]);
        int pos2 = b2 + pos - b1;
        root.left = _buildTree(b1, pos, b2, pos2);
        root.right = _buildTree(pos+1, e1, pos2, e2-1);
        return root;
    }

// 使用哈希表代替搜索下标索引
//    public int arraySearch(int[] array, int target, int begin, int end) {
//        for (int i = begin; i < end; i++) {
//            if (array[i] == target) return i;
//        }
//        return -1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


}

// 因为存在数组的复制，所以比较耗时，但是思路还是挺清晰的，就是构造一个递归的过程，然后结合回溯
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        int length = inorder.length;
//        if (length == 0) return null;
//        if (length == 1) {
//            return new TreeNode(inorder[0]);
//        }
//        TreeNode root = new TreeNode(postorder[length - 1]);
//        int pos = arraySearch(inorder, postorder[length - 1]);
//        root.left = buildTree(Arrays.copyOfRange(inorder, 0, pos), Arrays.copyOfRange(postorder, 0, pos));
//        root.right = buildTree(Arrays.copyOfRange(inorder, pos+1, length), Arrays.copyOfRange(postorder, pos, length-1));
//        return root;
//    }
//    public int arraySearch(int[] array, int target) {
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == target) return i;
//        }
//        return -1;
//    }