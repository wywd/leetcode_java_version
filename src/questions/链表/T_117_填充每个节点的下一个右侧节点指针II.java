package questions.链表;

// 给定一个二叉树：
/**
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
**/
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
// 初始状态下，所有next 指针都被设置为 NULL。
//
// 进阶：
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/

public class T_117_填充每个节点的下一个右侧节点指针II {  // 和 116题 不同，这题的树不是完美二叉树
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node root = new Node(0);
        Node t1 = new Node(2);
        Node t2 = new Node(4);
        Node t3 = new Node(1);
        Node t4 = new Node(3);
        Node t5 = new Node(-1);
        Node t6 = new Node(5);
        Node t7 = new Node(1);
        Node t8 = new Node(6);
        Node t9 = new Node(8);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.right = t8;
        t5.right = t9;
        Node connect = new T_117_填充每个节点的下一个右侧节点指针II().connect(root);
    }

    public Node connect(Node root) {
        Node firstNode = root;  // 当前层的节点，处理下一层next节点
        while (firstNode != null) {
            Node downNode = null;  // 下一层最左边的节点（因为不是完美二叉树，所以需要寻找）
            Node pre = firstNode;  // 用两个指针在这一层中通过next移动，表示有孩子节点的两个前后父节点，用于不同节点中间的孩子连接
            Node cur = firstNode;
            boolean flag = true;
            while (cur != null) {
                if (cur.left != null) {  // 如果左孩子存在，
                    if (flag) {
                        downNode = cur.left;
                        flag = false;
                    }
                    cur.left.next = cur.right;  // 那么可以在节点内进行连接，
                    if (cur != pre) {  // 然后连接不同节点的孩子
                        if (pre.right != null) {
                            pre.right.next = cur.left;
                        } else if (pre.left != null){
                            pre.left.next = cur.left;
                        }
                    }
                    pre = cur;
                    cur = cur.next;
                } else if (cur.right != null) {  // 如果左孩子不存在，
                    if (flag) {
                        downNode = cur.right;
                        flag = false;
                    }
                    if (cur != pre) {  // 则考虑连接不同节点的孩子
                        if (pre.right != null) {
                            pre.right.next = cur.right;
                        } else if (pre.left != null) {
                            pre.left.next = cur.right;
                        }
                    }
                    pre = cur;
                    cur = cur.next;
                } else {
                    cur = cur.next;
                }
            }
            firstNode = downNode;  // 更新新的最左节点
        }
        return root;
    }

    // 思路同上，代码进一步封装，并采用了递归的方式
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {  // 如果左右孩子均存在，则左孩子和右孩子进行内部连接
            root.left.next = root.right;
        }
        if (root.left != null && root.right == null) {  // 如果右孩子不存在，则将左孩子连接到后面的孩子节点
            root.left.next = getNext(root.next);
        }

        if (root.right != null) {  // 如果右孩子存在，那么需要连接右孩子
            root.right.next = getNext(root.next);
        }
        connect2(root.right);  // 这里注意要先处理后面的节点，再处理前面的节点
        connect2(root.left);
        return root;
    }

    public Node getNext(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        return getNext(root.next);
    }
    // 这题因为不是完全二叉树，难度更大。常规方法可以采用bfs+队列的方式解决（需要o(n)空间）。也可以利用next节点一层一层遍历，比116题复杂一些
}
