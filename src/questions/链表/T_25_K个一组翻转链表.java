package questions.链表;

// 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
// 你不能只是单纯地改变节点内部的值，而是需要实际进行节点交换。
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
//
// https://leetcode.cn/problems/reverse-nodes-in-k-group/



public class T_25_K个一组翻转链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {  // 采用迭代的思路
        ListNode dummy = new ListNode(-1, head);  // 虚拟头节点
        ListNode cur = dummy;
        int count = k;
        while (cur != null && count > 0) {
            count--;
            cur = cur.next;
        }
        if (cur == null) {
            return head;
        }
        cur = head;
        dummy.next = null;
        // 否则存在k个节点，进行逆序（逆序的过程采用迭代的思路）
        for (int i = 0; i < k; i++) {
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }
        head.next = reverseKGroup(cur, k);  // 这里采用了递归的思路
        return dummy.next;
    }


    // 这道题其实是链表逆序(206)和两两交换链表中节点(24)的一个组合；既可以采用递归的方法，也可以采用迭代的方法
}
