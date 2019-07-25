package Tree; /**
 * created by Zheng Jiateng on 2019/5/29.
 */

import base.TreeNode;

/**
 * 101. Symmetric Tree
 *
 * 判断二叉树是不是对称 递归法和迭代法
 * 思路：判断此树的左子树和右子树是不是对称的
 */
public class IsSymmetric__ {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetric(root.left, root.right);
    }

    // 判断两个二叉树是不是对称的
    private boolean symmetric(TreeNode x, TreeNode y){
        if(x == null && y == null) return true;
        if(x == null || y == null ) return false;
        return x.val == y.val && symmetric(x.left, y.right) && symmetric(x.right, y.left);
    }
}
