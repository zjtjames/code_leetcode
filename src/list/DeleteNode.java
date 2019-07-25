package list; /**
 * created by Zheng Jiateng on 2019/4/29.
 */

import base.ListNode;

/**
 * 删除列表结点 237. Delete Node in a Linked List
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
