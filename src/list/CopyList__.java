package list; /**
 * created by Zheng Jiateng on 2019/6/24.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * 复杂链表的深复制 要点是返回结果中不能带有原链表的结点引用
 *
 * 思路：先把每个结点建出来 存在Map中 再循环一遍给random复制
 */
public class CopyList__ {
    public Node copyRandomList(Node head) {
        Node cur1 = head;
        Node dummy = new Node();
        Node cur2 = dummy;
        // 存映射 后面为random赋值用
        HashMap<Node, Node> map = new HashMap<>();
        while(cur1 != null){
            Node node = new Node();
            node.val = cur1.val;
            map.put(cur1, node);
            cur2.next = node;
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        for(Map.Entry<Node, Node> entry : map.entrySet()){
            entry.getValue().random = map.get(entry.getKey().random);
        }
        return dummy.next;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
