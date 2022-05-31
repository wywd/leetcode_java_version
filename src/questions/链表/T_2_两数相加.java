package questions.链表;

// 给你两个 非空 的链表，表示两个非负的整数。
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// https://leetcode.cn/problems/add-two-numbers/

public class T_2_两数相加 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(-1);  // 虚拟头节点，使编码简洁
        ListNode cur = head;
        int rest = 0;  // 存储进位
        while (p1 != null && p2 != null) {  // 已经是逆序了，直接依次相加
            int v = p1.val + p2.val + rest;  // 记得加上前一次的进位
            rest = v / 10;  // 更新进位
            ListNode node = new ListNode(v % 10);
            cur.next = node;
            cur = node;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int v  = p1.val + rest;
            rest = v / 10;
            ListNode node = new ListNode(v % 10);
            cur.next = node;
            cur = node;
            p1 = p1.next;
        }
        while (p2 != null) {
            int v  = p2.val + rest;
            rest = v / 10;
            ListNode node = new ListNode(v % 10);
            cur.next = node;
            cur = node;
            p2 = p2.next;
        }
        if (rest > 0) {  // 这一步一定不能丢！
            cur.next = new ListNode(rest);
        }
        return head.next;
    }
}
