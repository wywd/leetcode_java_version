package questions.链表;

// 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
// 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//你应当 保留 两个分区中每个节点的初始相对位置。
//
// https://leetcode.cn/problems/partition-list/


public class T_86_分隔链表 {
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

    public ListNode partition(ListNode head,int x){
        if (head == null) {
            return null;
        }
        ListNode dummy1 = new ListNode(-1);  // 连接小于x的节点
        ListNode dummy2 = new ListNode(-1);  // 连接大于等于x的节点
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode cur = head;
        while (cur != null) {  // 将链表中的节点分配到对应的链表中
            if (cur.val < x) {
                p1.next = cur;
                p1 = cur;
            } else {
                p2.next = cur;
                p2 = cur;
            }
            cur = cur.next;
        }
        p1.next = dummy2.next;
        p2.next = null;
        return dummy1.next;
    }

}
