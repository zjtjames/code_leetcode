/**
 * created by Zheng Jiateng on 2019/8/16.
 */
package Tree;

import base.ListNode;
import base.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * eg: 给定的有序链表： [-10, -3, 0, 5, 9]
 *
 * 思路：让创建TreeNode的顺序与链表顺序相同 想到二叉搜索树中序遍历是升序的 所以模拟中序遍历
 * 每次按照当前链表结点值创建TreeNode后，链表指针next
 * 关键是设置lo hi两个指针
 */
public class SortedListToBST__ {
    private ListNode node; // 链表当前结点

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        node = head;
        while (head != null) {
            n++;
            head = head.next;
        }
        return inOrder(0, n - 1);
    }

    private TreeNode inOrder(int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode left = inOrder(lo, mid - 1); // 建好左子树 因为是中序遍历 所以此时node指向包含此左子树的根结点
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = left;
        root.right = inOrder(mid + 1, hi);
        return root;
    }
}
