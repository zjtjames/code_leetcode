/**
 * created by Zheng Jiateng on 2019/8/13.
 */
package hard;

import base.ListNode;

/**
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy; // pre指向待翻转区域的上一个结点
        ListNode end = dummy; // end指向待翻转区域的最后一个结点
        while(end.next != null){
            for(int i = 0; i < k && end != null; i++) end = end.next; // 因为设置了虚头 所以循环结束时end指向第k个结点
            if(end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
