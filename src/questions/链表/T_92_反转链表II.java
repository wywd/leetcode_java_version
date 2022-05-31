package questions.链表;

// 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
// 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
// 提示：
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
// https://leetcode.cn/problems/reverse-linked-list-ii/

public class T_92_反转链表II {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 首先进行特殊情况讨论（剪枝）
        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }
        // 然后找到left节点的前一个节点，这里借助 虚拟头节点 简化编码
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }
        int count = right - left + 1; // 需要逆序的链表长度
        ListNode last = cur.next;  // 提前保存逆序部分的尾节点（开始前就是需要逆序部分的头节点）

        // 逆序的过程
        ListNode pre = cur;
        cur = cur.next;
        pre.next = null;
        for (int i = 0; i < count; i++) {
            ListNode tmp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tmp;
        }
        // 连接起来
        last.next = cur;
        return dummy.next;
    }
}
