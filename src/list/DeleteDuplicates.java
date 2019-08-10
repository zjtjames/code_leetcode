/**
 * created by Zheng Jiateng on 2019/8/11.
 */
package list;

import base.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 思路：双指针 记录previous
 * 技巧 用虚头 防止表头被删
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode previous = dummy;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                // 一直走到重复元素的最后一个
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                previous.next = cur.next; // 这一行是重点
                cur = cur.next;
            }else{
                previous = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
