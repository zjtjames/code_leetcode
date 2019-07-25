package list; /**
 * created by Zheng Jiateng on 2019/5/12.
 */

import base.ListNode;

/**
 * 142. Linked List Cycle II  找链表的圈的起点
 *
 * 弗洛伊德判圈法
 */
public class DetectCycle__ {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode quick = head;
        ListNode slow = head;
        while(true){
            if(quick == null || quick.next == null) return null;
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow) break;
        }
        quick = head;
        while(quick != slow){
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }
}
