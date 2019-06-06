/**
 * created by Zheng Jiateng on 2019/6/6.
 */

import base.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * 只走一遍 删除链表倒数第N个结点
 *
 * 思路：双指针法 两指针始终相距n 第一个指针到尾时 第二个指针正好指向要移除的结点
 * 精髓是设置虚指针来简化边界条件
 */
public class RemoveNthFromEnd__ {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0; i < n; i++){
            first = first.next;
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
