package questions.链表;

// 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
// 输入：head = [1,2,3,3,4,4,5]
// 输出：[1,2,5]
//
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/

public class T_82_删除排序链表中的重复元素II {
    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {  // 双指针的思路
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;  // pre保存已经处理好的链表尾节点
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            if (left.val != right.val) {
                pre = left;
            } else {
                while (right != null && right.val == left.val) {
                    right = right.next;
                }
                if (right == null) {
                    pre.next = null;
                    break;
                }
                pre.next = right;
            }
            left = right;
            right = right.next;
        }
        return dummy.next;
    }
}
