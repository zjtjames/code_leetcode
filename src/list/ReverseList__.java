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
 * if判断设置新头是易漏点
 */
public class ReverseList__ {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode previous = null;
        ListNode next = null;
        ListNode node = head;
        ListNode newHead = null;
        while(node != null){
            if(node.next == null){ // 这个if判断设置新头是易漏点
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
