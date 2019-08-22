/**
 * created by Zheng Jiateng on 2019/8/22.
 */
package list;

import base.ListNode;

/**
 * 234. 回文链表
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 思路：反转前一半链表 然后逐个结点对比值
 * 链表题的经典思路就是反转链表
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode secondHead = null;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        if(quick == null) secondHead = slow;
        else secondHead = slow.next;
        while(pre != null){
            if(pre.val != secondHead.val) return false; // 注意要比val 不是直接比引用
            pre = pre.next;
            secondHead = secondHead.next;
        }
        return true;
    }
}
