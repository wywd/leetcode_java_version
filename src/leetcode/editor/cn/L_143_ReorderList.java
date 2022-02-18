/**
给定一个单链表 L 的头节点 head ，单链表 L 表示为： 

 
L0 → L1 → … → Ln - 1 → Ln
 

 请将其重新排列后变为： 

 
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 

 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 

 

 示例 1： 

 

 
输入：head = [1,2,3,4]
输出：[1,4,2,3] 

 示例 2： 

 

 
输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3] 

 

 提示： 

 
 链表的长度范围为 [1, 5 * 10⁴] 
 1 <= node.val <= 1000 
 
 Related Topics 栈 递归 链表 双指针 👍 796 👎 0

*/

package leetcode.editor.cn;

public class L_143_ReorderList {
    public static void main(String[] args) {
        Solution solution = new L_143_ReorderList().new Solution();
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode left = head;
        ListNode right = head;
        while (right.next != null && right.next.next != null) {
            right = right.next.next;
            left = left.next;
        }
        ListNode p = left;
        left = left.next;
        p.next = null;  // 避免链表循环
        p = left;
        // 翻转链表
        ListNode header = new ListNode(0, null);
        while (p != null) {
            ListNode temp = p.next;
            p.next = header.next;
            header.next = p;
            p = temp;
        }
        right = header.next;
        left = head;
        // 将right中的节点插入left中
        while (right != null) {
            ListNode temp = left.next;
            left.next = right;
            left = temp;
            temp = right.next;
            right.next = left;
            right = temp;
        }
//        left.next = null;  // 上面null了，就不需要这个了
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}