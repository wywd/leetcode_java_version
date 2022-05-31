package questions.链表;

// 给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
//
//本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
//
// https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/

import com.sun.source.tree.Tree;

public class T_109_有序链表转换二叉搜索树 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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

    ListNode prev;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
//        return buildBST(head, null);  // 方法一

        // 方法二
        int size = getLength(head);
        prev = head;
        return buildBST2(0, size - 1);  // 全闭
    }

    TreeNode buildBST(ListNode left, ListNode right) {  // 分治的思想
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBST(left, mid);
        root.right = buildBST(mid.next, right);
        return root;
    }

    TreeNode buildBST2(int left, int right) {  // 分治的思想 + 中序遍历优化
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode();
        root.left = buildBST2(left, mid - 1);
        // 中序遍历思想
        root.val = prev.val;
        prev = prev.next;
        root.right = buildBST2(mid + 1, right);
        return root;
    }

    ListNode getMedian(ListNode left, ListNode right) {  // 寻找中间点（这一步可以进行优化）
        ListNode fast = left;
        ListNode snow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            snow = snow.next;
        }
        return snow;
    }

    int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
