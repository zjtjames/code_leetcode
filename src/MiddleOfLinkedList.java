/**
 * created by Zheng Jiateng on 2019/6/15.
 */

import base.ListNode;

/**
 * 876. Middle of the Linked List
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null) return head;
        ListNode quick = head;
        ListNode slow = head;
        while(quick.next != null){
            if(quick.next.next == null) return slow.next;
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
