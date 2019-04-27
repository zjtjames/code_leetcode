import base.TreeNode;

/**
 * created by Zheng Jiateng on 2019/4/27.
 */

/**
 * 树的最大深度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        } else{
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
