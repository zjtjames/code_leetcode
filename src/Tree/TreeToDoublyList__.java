/**
 * created by Zheng Jiateng on 2019/8/12.
 */
package Tree;

import base.TreeNode;

/**
 * 426. 将二叉搜索树转化为排序的双向链表
 *
 * 思路：关键点是记录当前链表中最大的元素last,将last与中序遍历遇到的下一个结点相连
 */
public class TreeToDoublyList__ {
    private TreeNode first = null; //记录链表头
    private TreeNode last = null; //当前链表中最大的元素

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return root;
        inOrder(root);
        first.left = last;
        last.right = first;
        return first;
    }
    // 记录当前链表中最大的元素last,将last与中序遍历遇到的下一个结点相连
    private void inOrder(TreeNode root){
        if(root != null) {
            inOrder(root.left);
            if(last != null){
                last.right = root;
                root.left = last;
            } else{ // 如果没有上一个元素 说明是最小元素 赋值给表头
                first = root;
            }
            last = root;
            inOrder(root.right);
        }
    }
}
