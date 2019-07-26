package hard; /**
 * created by Zheng Jiateng on 2019/6/21.
 */

import java.util.HashMap;

/**
 * 146. LRU Cache 最久未用策略
 * 要求get和put都是o(1)
 *
 * 思路: HashMap + 双向链表（把每个结点存在HashMap中） LinkedList基于双向链表 但不是双向链表本身 本身是node
 * A B C D E D F
 * head -> tail
 * head -> A -> tail
 * head -> B -> A -> tail
 */
public class LRUCache__ {
    private HashMap<Integer, DeNode> map;
    int capacity;
    DeNode head, tail;

    public LRUCache__(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DeNode(0, 0);
        tail = new DeNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }

    public int get(int key) {
        // 更新链表
        if (map.get(key) != null) {
            DeNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 如果key已存在 则替换value为新value 并更新链表
        if (map.get(key) != null) {
            DeNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else { // 如果key不存在 则有可能要移除最久未用元素
            DeNode node = new DeNode(key, value);
            map.put(key, node);
            if (map.size() <= capacity) {
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    private void deleteNode(DeNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    // 最新用过的链到head后
    private void addToHead(DeNode node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    // 双向链表
    class DeNode{
        int key;
        int value;
        DeNode pre;
        DeNode next;

        public DeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // HashMap的值可以是null
    public static void main(String[] args) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, null);
        System.out.println(map1.get(2));
    }
}
