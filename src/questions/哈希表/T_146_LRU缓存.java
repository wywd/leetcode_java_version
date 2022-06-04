package questions.哈希表;

// 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
// 实现 LRUCache 类：
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
// https://leetcode.cn/problems/lru-cache/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class T_146_LRU缓存 {

}

class LRUCache {

    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;

        public ListNode() {}

        public ListNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    Map<Integer, ListNode> cache;
    int size;
    int capacity;
    ListNode head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        size = 0;
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node != null) {
            node.val = value;   // 还需要更新
            moveToHead(node);
        } else {
            node = new ListNode(value, key);
            // 插入到链表头
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            cache.put(key, node);
            size++;
            if (size > capacity) {
                ListNode garbage = tail.prev;
                garbage.prev.next = garbage.next;
                garbage.next.prev = garbage.prev;
                cache.remove(garbage.key);
                size--;
            }
        }
    }

    private void moveToHead(ListNode node) {
        // 从双向链表原始位置删除，移动到链表头
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
