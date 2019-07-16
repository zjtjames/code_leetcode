import base.ListNode;

/**
 * created by Zheng Jiateng on 2019/5/8.
 */

/**
 * 148. Sort List
 * O(1)空间复杂度，O(nlogn)时间复杂度排序链表
 * 自底向上循环归并排序适合链表排序。

 */
public class SortList__ {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 链表长度
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        ListNode storeHead = new ListNode(0);
        storeHead.next = head;
        ListNode left;
        ListNode right;
        ListNode tail;
        for (int step = 1; step < length; step = step + step) { // step为子数组大小
            cur = storeHead.next;
            tail = storeHead;
            while (cur != null) {
                left = cur;
                right = split(left, step); // 使第一个链表与后面的断开
                cur = split(right, step); // 使第二个链表与后面的断开
                tail = merge(left, right, tail);
            }
        }
        return storeHead.next;
    }

    /**
     * 将链表分为两个链表 使得第一个链表有n个结点
     * @return 返回第二个链表的头
     */
    private ListNode split(ListNode head, int n) {
        for (int i = 1; head != null && i < n; i++) {
            head = head.next;
        }
        if (head == null) { // 如果长度不够n了 返回null 赋给37行的cur 让while结束
            return null;
        }
        ListNode second = head.next;
        head.next = null; // 使第一个链表与后面的断开
        return second;
    }

    /**
     * 将l1和l2两个链表归并，头为head
     *
     * @return 返回归并后的链表的尾
     */
    private ListNode merge(ListNode l1, ListNode l2, ListNode head) {
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2; // 这就是链表适合自底向上归并排序的原因 只需要重新连接结点 不需要创建任何新的结点
                cur = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
        }
        cur.next = l1 != null ? l1 : l2;
        while (cur.next != null) {
            cur = cur.next; // 将游标移到链表尾
        }
        return cur;
    }
}
