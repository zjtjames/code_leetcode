package list; /**
 * created by Zheng Jiateng on 2019/4/29.
 */

import base.ListNode;

/**
 * 反转链表 206. Reverse Linked List
 * 输入: 1->2->3->4->5->NULL
 * 输出: NULL<-1<-2<-3<-4<-5
 *
 * 要点：三个指针 一个指向当前节点，一个指向前一个，一个提前保存后一个节点，防止链表断裂
 * 直接用head当游标
 */
public class ReverseList__ {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode previous = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}
