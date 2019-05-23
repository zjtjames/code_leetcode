import base.TreeNode;

/**
 * created by Zheng Jiateng on 2019/5/23.
 */

/**
 * 236. Lowest Common Ancestor of a Binary Tree 最低公共祖先
 *
 * 思路：递归遍历二叉树 最低公共祖先必须是根结点或左子树有p或q中的一个，右子树有另一个
 */
public class LowestCommonAncestor__ {
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPOrQ(root, p, q);
        return result;
    }

    private boolean findPOrQ(TreeNode node, TreeNode p, TreeNode q){
        if(node != null){
            boolean itself = node.val == p.val || node.val == q.val;
            boolean left = findPOrQ(node.left, p, q);
            boolean right = findPOrQ(node.right, p, q);
            if(itself && left || itself && right || left && right){
                result = node;
            }
            return itself || left || right;
        }
        return false;
    }
}
