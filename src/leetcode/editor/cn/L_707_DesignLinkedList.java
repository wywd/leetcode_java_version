/**
设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引
用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 

 在链表类中实现这些功能： 

 
 get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
 addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
 addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
 addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加到链
表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
 deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
 

 

 示例： 

 MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-> 3
linkedList.get(1);            //返回3
 

 

 提示： 

 
 所有val值都在 [1, 1000] 之内。 
 操作次数将在 [1, 1000] 之内。 
 请不要使用内置的 LinkedList 库。 
 
 Related Topics 设计 链表 👍 354 👎 0

*/

package leetcode.editor.cn;

public class L_707_DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList solution = new L_707_DesignLinkedList().new MyLinkedList();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode pre, next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
}

    class MyLinkedList {
        private ListNode head, tail;
        private int size;

        public MyLinkedList() {
            head = new ListNode(0); // 这两个都是虚节点
            tail = new ListNode(0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            if (index < size / 2) {
                for (int i = 0; i <= index; i++) {
                    cur = cur.next;
                }
                return cur.val;
            } else {
                cur = tail;
                for (int i = size; i > index; i--) {
                    cur = cur.pre;
                }
                return cur.val;
            }
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            } else if (index == size) {
                addAtTail(val);
            } else if (index < 0) {
                addAtHead(val);
            } else {
                ListNode cur = head;
                if (index < size / 2) {
                    for (int i = 0; i <= index; i++) {
                        cur = cur.next;
                    }
                } else {
                    cur = tail;
                    for (int i = size; i > index; i--) {
                        cur = cur.pre;
                    }
                }
                ListNode node = new ListNode(val);
                node.next = cur;
                node.pre = cur.pre;
                cur.pre.next = node;
                cur.pre = node;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                ListNode cur = head;
                if (index < size / 2) {
                    for (int i = 0; i <= index; i++) {
                        cur = cur.next;
                    }
                } else {
                    cur = tail;
                    for (int i = size; i > index; i--) {
                        cur = cur.pre;
                    }
                }
                cur.next.pre = cur.pre;
                cur.pre.next = cur.next;
                cur.pre = cur.next = null;
                size--;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)


}