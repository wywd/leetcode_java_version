package questions.链表;

// 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
// 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
// https://leetcode.cn/problems/swap-nodes-in-pairs/

public class T_24_两两交换链表中的节点 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    // 迭代的思路
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);  // 链表的题目一定要考虑虚拟节点
        ListNode pre = dummy;  // 前一个节点
        ListNode p = head;  // 当前节点
        while (p != null && p.next != null) {  // 只有当前位置和下一个位置都存在节点在进行交换
            ListNode temp = p.next.next;  // 临时变量保存下一次迭代的起点
            p.next.next = p;
            pre.next = p.next;
            p.next = temp;
            pre = p;
            p = temp;
        }
        return dummy.next;
    }

    // 递归的思路
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = swapPairs2(head.next.next);
        ListNode cur = head.next;
        head.next = tmp;
        cur.next = head;
        return cur;
    }
}
