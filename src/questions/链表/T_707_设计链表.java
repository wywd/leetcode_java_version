package questions.链表;

// 设计链表的实现。您可以选择使用单链表或双链表。
// 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
// 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
// 假设链表中的所有节点都是 0-index 的。
// 在链表类中实现这些功能：
// 1. get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
// 2. addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
// 3. addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
// 4. addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
// 如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
// 如果index小于0，则在头部插入节点。
// 5. deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
// https://leetcode.cn/problems/design-linked-list/

public class T_707_设计链表 {

}

class Node {
    int val;
    Node next;
    Node prev;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

}

// 实现了一个双向链表
class MyLinkedList {

    Node head;  // 头节点是虚拟节点
    Node tail;  // 尾节点也是虚拟节点
    int size;

    // 初始化链表
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        Node p = getNode(index);
        return p.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
        } else if (index < 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node p = getNode(index);
            Node newNode = new Node(val);
            newNode.next = p;
            newNode.prev = p.prev;
            p.prev.next = newNode;
            p.prev = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node p = getNode(index);
        p.prev.next = p.next;
        p.next.prev = p.prev;
        p.next = p.prev = null;
        size--;
    }

    private Node getNode(int index) {
        Node p = head;
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
        } else {
            p = tail;
            for (int i = size; i > index; i--) {
                p = p.prev;
            }
        }
        return p;
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