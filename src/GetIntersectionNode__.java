/**
 * created by Zheng Jiateng on 2019/5/31.
 */

import base.ListNode;

/**
 * 160. Intersection of Two Linked Lists 找两个链表的交点
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

 * 思路：两个指针 分别从A和B的头开始走 A走到尾续到B的头接着走 B走到尾续到A的头接着走 两指针相遇是恰好就在交点
 * 证明：设相交部分长为c A在交点之前长a B在交点之前长b 则相遇时 a+c+b = b+c+a 刚好在交点相遇
 * 若两链表不相交 则会在null处相遇 刚好返回null
 */
public class GetIntersectionNode__ {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;
        while(curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
