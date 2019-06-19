/**
 * created by Zheng Jiateng on 2019/6/18.
 */

import base.ListNode;

/**
 * 2. Add Two Numbers
 */
public class AddTwoNumbers__ {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while(p != null || q != null){
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(carry != 0) cur.next = new ListNode(carry);
        return dummyHead.next;
    }
}
