package questions.链表;

// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
// https://leetcode.cn/problems/reverse-linked-list/

public class T_206_反转链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {  // 迭代
        ListNode dummy = new ListNode(-1, null);
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = temp;
        }
        return dummy.next;
    }

    public ListNode reverseList2(ListNode head) {  // 递归的方法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
