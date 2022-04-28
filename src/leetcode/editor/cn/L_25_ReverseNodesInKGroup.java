/**
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 

 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 

 

 示例 1： 

 
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
 

 示例 2： 

 

 
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
 

 
提示：

 
 链表中的节点数目为 n 
 1 <= k <= n <= 5000 
 0 <= Node.val <= 1000 
 

 

 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 

 
 
 Related Topics 递归 链表 👍 1597 👎 0

*/

package leetcode.editor.cn;

public class L_25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new L_25_ReverseNodesInKGroup().new Solution();
        ListNode t1 = new ListNode(5, null);
        ListNode t2 = new ListNode(4, t1);
        ListNode t3 = new ListNode(3, t2);
        ListNode t4 = new ListNode(2, t3);
        ListNode t5 = new ListNode(1, t4);
        ListNode node = solution.reverseKGroup(t5, 2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
     public static class ListNode {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode Dhead = new ListNode(0, head);
        ListNode p = Dhead;
        int count = k;
        while (p != null && count > 0) {
            p = p.next;
            count--;
        }
        if (p == null) {  // 说明不够k个节点了
            return head;
        }
        p = head;
        Dhead.next = null;
        for (int i = 0; i < k; i++) {  // 逆序k个节点
            ListNode temp = p.next;
            p.next = Dhead.next;
            Dhead.next = p;
            p = temp;
        }
        head.next = reverseKGroup(p, k);
        return Dhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}