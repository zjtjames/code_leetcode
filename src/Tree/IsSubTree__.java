package Tree; /**
 * created by Zheng Jiateng on 2019/7/20.
 */

import base.TreeNode;

/**
 * 572. Subtree of Another Tree
 * * 一棵树是不是另一棵树的子树
 * s 的一个子树应包括 s 的一个节点和这个节点的所有子孙。
 * eg:
 * 给定的树 s：
     3
    / \
   4   5
  / \
 1   2
    /
   0
 给定的树 t：
   4
  / \
 1   2

 返回 false。
 */
public class IsSubTree__ {
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return isSame(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    // 判断两棵树是否完全相等
    private boolean isSame(TreeNode x, TreeNode y) {
        if(x == null && y == null) return true;
        if(x == null || y == null) return false; // x和y没有同时遍历完 说明不是子树
        return x.val == y.val && isSame(x.left, y.left) && isSame(x.right, y.right);
    }
}
