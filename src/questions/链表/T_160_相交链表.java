package questions.链表;

// 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
// 如果两个链表不存在相交节点，返回 null 。
// https://leetcode.cn/problems/intersection-of-two-linked-lists/

public class T_160_相交链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tail = headA;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = headA;
        ListNode fast = headB;
        ListNode snow = headB;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            snow = snow.next;
            if (snow == fast) {  // 说明存在交点
                snow = headB;
                while (snow != fast) {
                    snow = snow.next;
                    fast = fast.next;
                }
                tail.next = null;
                return snow;
            }
        }
        tail.next = null;  // 恢复原始结构
        // 能够退出循环，说明不存在环
        return null;
    }
}
