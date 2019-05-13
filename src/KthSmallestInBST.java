/**
 * created by Zheng Jiateng on 2019/5/12.
 */

import base.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 *
 * 中序遍历
 */
public class KthSmallestInBST {

    private int result;
    private int count; // 全局变量一定要定义为实例变量

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k){
        if(root != null && count < k){
            inorder(root.left, k);
            if(count < k){
                count++;
                result = root.val;
            }
            inorder(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node4;
        node1.right = node2;
//        System.out.println(kthSmallest(root, 1));
    }
}
