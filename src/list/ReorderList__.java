/**
 * created by Zheng Jiateng on 2019/7/26.
 */
package list;

import base.ListNode;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 思路：分三步：1.找到链表中点 2.从中点打断成两个链表 反转后一个链表 3.归并两个链表
 * 记住要用快慢指针法找链表的某一个结点
 */
public class ReorderList__ {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode previous = null;
        ListNode next = null;
        ListNode cur = secondHead;
        while(cur != null){
            if(cur.next == null){
                secondHead = cur;
            }
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        cur = head;
        ListNode cur2 = secondHead;
        while(cur != null && cur2 != null){
            next = cur.next;
            cur.next = cur2;
            cur2 = cur2.next; // 注意这一行的顺序
            cur = cur.next;
            cur.next = next;
            cur = cur.next;
        }
    }
}
