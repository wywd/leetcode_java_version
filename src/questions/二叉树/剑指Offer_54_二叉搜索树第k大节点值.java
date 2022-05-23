package questions.二叉树;

// 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
// https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/

public class 剑指Offer_54_二叉搜索树第k大节点值 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    int res = 0;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        travel(root);
        return res;
    }

    public void travel(TreeNode root) {  // 递归的写法
        if (root == null) {
            return;
        }
        travel(root.right);  // 中序遍历的方式，第k大的元素，所以采用右-中-左的dfs顺序
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        travel(root.left);
    }
}
