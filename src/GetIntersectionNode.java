/**
 * created by Zheng Jiateng on 2019/5/31.
 */

import base.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while(curA != null){
            lenA++;
            curA = curA.next;
        }
        while(curB != null){
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++){
                curA = curA.next;
            }
        } else {
            for(int i = 0; i < lenB - lenA; i++){
                curB = curB.next;
            }
        }
        while(curA != null){
            if(curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
