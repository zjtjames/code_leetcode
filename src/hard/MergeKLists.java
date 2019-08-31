/**
 * created by Zheng Jiateng on 2019/7/28.
 */
package hard;

import base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23.合并K个排序链表 合并 k 个排序链表，返回合并后的排序链表。
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 思路：建立最小堆 每次找三个表头中的最小值
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len < 1) return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 建立小顶堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) pq.offer(head);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
