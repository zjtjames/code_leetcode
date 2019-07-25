package list; /**
 * created by Zheng Jiateng on 2019/5/14.
 */

import base.ListNode;

/**
 * 141. Linked List Cycle
 *
 * 弗洛伊德判圈法
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                return true;
            }
        }
        return false;
    }
}
