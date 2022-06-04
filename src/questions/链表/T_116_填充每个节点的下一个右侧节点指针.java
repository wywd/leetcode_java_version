package questions.链表;

// 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

import java.util.ArrayDeque;
import java.util.Deque;

/** struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
 }
**/
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
// 初始状态下，所有 next 指针都被设置为 NULL.
// 进阶：
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/

public class T_116_填充每个节点的下一个右侧节点指针 {
    class Node {
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
    public Node connect(Node root) {  // 利用bfs+队列的方法，思路很简单，但是需要额外队列的空间
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        Node prev = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.pollFirst();
                if (i > 0) {
                    prev.next = tmp;
                }
                prev = tmp;
                if (tmp.left != null) {
                    queue.offerLast(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offerLast(tmp.right);
                }
            }
        }
        return root;
    }

    public Node connect2(Node root) {  // 利用递归的方法，同时充分利用next指针
        if (root == null) {
            return null;
        }
        Node left = connect2(root.left);
        Node right = connect2(root.right);
        if (left != null && right != null) {  // 因为是完美二叉树，所以要么都是null，要么全不为null
            left.next = right;
            while (left.right != null) {  // 两颗子树的鸿沟包括下面的每一层，而不是仅仅一层
                left.right.next = right.left;
                // 下面这二步很关键，仔细体会。
                left = left.right;
                right = right.left;
            }
        }
        return root;
    }

    // 充分利用建立的next指针，一层一层的从上往下建立next指针
    // https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
    public Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root;
        while (left.left != null) {
            Node cur = left;
            while (cur != null) {
                // 同一个父节点的孩子进行连接,
                cur.left.next = cur.right;
                // 不同父节点的孩子进行连接
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;  // 指针向右移动
            }
            // 移动到下一层最左边节点
            left = left.left;
        }
        return root;
    }
}
