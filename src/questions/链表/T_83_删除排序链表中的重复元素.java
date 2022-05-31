package questions.链表;

// 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
// 例子
// 输入：head = [1,1,2]
// 输出：[1,2]
//
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/

public class T_83_删除排序链表中的重复元素 {
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

    public ListNode deleteDuplicates(ListNode head) {  // 双指针
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            if (right.val != left.val) {
                left = right;
                right = right.next;
            } else {
                right = right.next;
                left.next = right;
            }
        }
        return dummy.next;
    }
}
