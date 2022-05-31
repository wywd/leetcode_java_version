package questions.链表;

// 给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/

public class T_114_二叉树展开为链表 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 递归的思路，利用后序遍历的思路（不过是右 - 左 - 中），从后往前串联起来
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // bfs递归思路（不优雅）
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }
    public TreeNode helper(TreeNode root) {
        if (root == null) {  // 空节点，直接返回
            return null;
        } else if (root.left == null) {  // 左节点为空，则直接将右子树展平并递归展开
            root.right = helper(root.right);
            return root;
        } else if (root.right == null) {  // 右节点为空，则将左子树移动到右边，并递归展开
            root.right = helper(root.left);
            root.left = null;
            return root;
        } else {  // 左右子树均不为空，
            TreeNode temp = helper(root.right);  // 先将右子树递归展开，它需要连接到左子树展开的末尾处
            root.right = helper(root.left);  // 将左子树移动到右边并递归展开
            root.left = null;
            // 这里是找到原左子树（现右子树）的末尾节点
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = temp;
            return root;
        }
    }
}
