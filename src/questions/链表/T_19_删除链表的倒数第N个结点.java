package questions.链表;

// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点.
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

public class T_19_删除链表的倒数第N个结点 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {

    }

    // 思路：快慢指针，让它们相距n，然后一起移动（题目已经保证n的范围正确）
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 首先还是增加一个虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode snow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            snow = snow.next;
        }
        snow.next = snow.next.next;
        return dummy.next;
    }
}
