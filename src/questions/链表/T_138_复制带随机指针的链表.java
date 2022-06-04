package questions.链表;


// 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
// 构造这个链表的 深拷贝。
// 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值
// 。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并
// 使原链表和复制链表中的这些指针能够表示相同的链表状态。
// 复制链表中的指针都不应指向原链表中的节点
//
// https://leetcode.cn/problems/copy-list-with-random-pointer/

import java.util.HashMap;
import java.util.Map;

public class T_138_复制带随机指针的链表 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 时间复杂度o(n)，空间复杂度o(n)
    public Node copyRandomList(Node head) {
        Map<Node, Node> old_to_new = new HashMap<>();

        Node dummy = new Node(-1);
        Node cur = dummy;
        Node tmp = head;

        // 先复制节点并建立map关系
        while (tmp != null) {
            cur.next = new Node(tmp.val);
            cur = cur.next;
            old_to_new.put(tmp, cur);
            tmp = tmp.next;
        }

        // 然后根据map连接这些新的节点
        tmp = head;
        while (tmp != null) {
            if (tmp.next != null) {
                old_to_new.get(tmp).next = old_to_new.get(tmp.next);
            }
            if (tmp.random != null) {
                old_to_new.get(tmp).random = old_to_new.get(tmp.random);
            }
            tmp = tmp.next;
        }

        return dummy.next;
    }

    // 回溯+哈希表的方式，时间复杂度和空间复杂度均为o(n)
    Map<Node, Node> map2 = new HashMap<>();
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (map2.get(head) == null) {  // 如果不存在
            Node newNode = new Node(head.val);
            map2.put(head, newNode);
            newNode.next = copyRandomList2(head.next);
            newNode.random = copyRandomList2(head.random);
        }
        return map2.get(head);
    }

    // 迭代 + 节点拆分 (时间复杂度 o(n)，空间复杂度o(1))
    // 思路比较巧妙
    // https://leetcode.cn/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }

        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        for (Node node = head; node != null; node = node.next.next) {
            node.next.random = node.random != null ? node.random.next : null;
        }

        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = node.next != null ? node.next.next : null;
        }
        return headNew;

    }

}
