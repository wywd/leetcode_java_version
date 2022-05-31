package questions.链表;

// 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
// https://leetcode.cn/problems/rotate-list/

public class T_61_旋转链表 {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        int size = 0;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        cur.next = head;   // 首位相连

        k = size - k % size;
        cur = dummy;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        dummy.next = cur.next;
        cur.next = null;
        return dummy.next;
    }
}
