/**
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    // 判断两棵树是否完全相等
    private boolean equals(TreeNode x, TreeNode y) {
        if(x == null && y == null) return true;
        else if(x == null || y == null) return false; // 这一行可以判断出示例的那种情况 2的左儿子是0和null
        else return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }

    // 遍历s树 直到找到子树或s树为null了
    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
}
