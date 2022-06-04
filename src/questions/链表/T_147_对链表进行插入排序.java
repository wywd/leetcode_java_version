package questions.链表;

// 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
//
//插入排序 算法的步骤:
//
//插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//重复直到所有输入数据插入完为止。
//
// https://leetcode.cn/problems/insertion-sort-list/

public class T_147_对链表进行插入排序 {
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

    // 递归的方式从后往前排序
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = insertionSortList(head.next);
        if (node == null) {
            return head;
        }
        if (node.val >= head.val) {
            head.next = node;
            return head;
        } else {
            ListNode p = node;
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            head.next = p.next;
            p.next = head;
            return node;
        }
    }

    // 迭代的方式从前往后排序
    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
            } else {
                ListNode cur  = dummy;
                while (cur.next.val < head.next.val) {
                    cur = cur.next;
                }
                ListNode tmp = head.next;
                head.next = head.next.next;
                tmp.next = cur.next;
                cur.next = tmp;
            }
        }
        return dummy.next;
    }
}
