/**
 * created by Zheng Jiateng on 2019/4/29.
 */

import base.ListNode;

/**
 * 反转链表 206. Reverse Linked List
 *
 * 三指针法
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode previous = null;
        ListNode next = null;
        ListNode node = head;
        ListNode newHead = null;
        while(node != null){
            if(node.next == null){
                newHead = node;
            }
            next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return newHead;
    }
}
