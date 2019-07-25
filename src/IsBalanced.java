/**
 * created by Zheng Jiateng on 2019/7/25.
 */

import base.TreeNode;

/**
 * 110. 平衡二叉树
 * 一棵高度平衡二叉树定义为：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
