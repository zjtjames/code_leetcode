/**
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
        ListNode slow = head;
        ListNode quick = head;
        boolean isCycle = false;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                isCycle = true;
                break;
            }
        }
        if(!isCycle){
            return null;
        }
        quick = head;
        while(quick != slow){
            quick = quick.next;
            slow = slow.next;
        }
        return quick;
    }
}
