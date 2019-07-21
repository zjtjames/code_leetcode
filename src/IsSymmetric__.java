/**
 * created by Zheng Jiateng on 2019/5/29.
 */

import base.TreeNode;

/**
 * 101. Symmetric Tree
 *
 * 判断二叉树是不是对称 递归法和迭代法
 */
public class IsSymmetric__ {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return core(root.left, root.right);
    }

    private boolean core(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null ) return false;
        return left.val == right.val && core(left.left, right.right) && core(left.right, right.left);
    }
}
