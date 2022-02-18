/**
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 

 

 示例 1： 

 
输入：head = [1,2,2,1]
输出：true
 

 示例 2： 

 
输入：head = [1,2]
输出：false
 

 

 提示： 

 
 链表中节点数目在范围[1, 10⁵] 内 
 0 <= Node.val <= 9 
 

 

 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
 Related Topics 栈 递归 链表 双指针 👍 1259 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class L_234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new L_234_PalindromeLinkedList().new Solution();
    }
    class ListNode {
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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode left = head;
        ListNode right = head;
        while (right.next != null && right.next.next != null) {
            right = right.next.next;
            left = left.next;
        }
        if (right.next != null) {  // 中间没有单节点
            if (left.val != left.next.val) {
                return false;
            } else {
                left = left.next.next;
            }
        } else {  // 有一个单节点
            left = left.next;
        }
        // 翻转后半部分链表
        ListNode header = new ListNode(0, null);
        ListNode cur = left;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = header.next;
            header.next = cur;
            cur = temp;
        }
        right = header.next;
        left = head;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)


}