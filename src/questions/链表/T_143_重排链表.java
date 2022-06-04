package questions.链表;

// 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//L0 → L1 → … → Ln - 1 → Ln
//请将其重新排列后变为：
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// https://leetcode.cn/problems/reorder-list/

public class T_143_重排链表 {
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode snow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            snow = snow.next;
        }

        ListNode dummy = new ListNode(-1, null);
        ListNode cur = snow.next;
        snow.next = null;  // !!!

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }

        ListNode p1 = head;
        ListNode p2 = dummy.next;
        cur = new ListNode(-1, null);
        while (p1 != null && p2 != null) {
            cur.next = p1;
            p1 = p1.next;
            cur = cur.next;

            cur.next = p2;
            p2 = p2.next;
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
    }

    // 腾讯TEG面试刷到过，思路就是先用快慢指针找到链表中点，然后将后半部分逆序，然后将这两部分合并起来
}




