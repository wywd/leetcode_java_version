package questions.二叉树;

// 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
// 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
// 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构
//
// https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/

import java.util.Arrays;

public class T_297_二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        Codec.TreeNode t1 = new Codec.TreeNode(4);
        Codec.TreeNode t2 = new Codec.TreeNode(5);
        Codec.TreeNode t3 = new Codec.TreeNode(3);
        Codec.TreeNode t4 = new Codec.TreeNode(2);
        Codec.TreeNode root = new Codec.TreeNode(1);
        t3.left = t1;
        t3.right = t2;
        root.left = t4;
        root.right = t3;
        String s = new Codec().serialize(root);
        System.out.println("s = " + s);
        root = new Codec().deserialize(s);
        System.out.println("root = " + root.toString());
    }
}

class Codec {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        _serialize(root, sb);
        return sb.toString();
    }

    void _serialize(TreeNode root, StringBuilder sb) {  // 先序遍历，
        if (root == null) {
            sb.append(",#");
            return;
        }
        sb.append(',').append(root.val);
        _serialize(root.left, sb);
        _serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int index = 1;
    String[] split;
    public TreeNode deserialize(String data) {
        split = data.split(",");
        return _deserialize();
    }

    TreeNode _deserialize() {
        if (index >= split.length || "#".equals(split[index])) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[index]));
        index++;
        root.left = _deserialize();
//        index++;
        root.right = _deserialize();
        return root;
    }
}
