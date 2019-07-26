/**
 * created by Zheng Jiateng on 2019/7/26.
 */
package list;

import base.ListNode;

/**
 * 92. 反转链表 II  反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        int index = 1;
        ListNode cur = head;
        ListNode left = null;
        while(index < m) {
            left = cur;
            cur = cur.next;
            index++;
        }
        ListNode tail = cur; // 记录反转后的尾部
        ListNode previous = null;
        ListNode next = null;
        while(index <= n){
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
            index++;
        }
        if(left != null) left.next = previous; // 这一行是关键 判断是否要改头
        else head = previous;
        tail.next = cur;
        return head;
    }
}
