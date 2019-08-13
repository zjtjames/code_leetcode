package Tree;

import base.TreeNode;

/**
 * created by Zheng Jiateng on 2019/4/27.
 */

/**
 * 树的最大深度 104.Maximum Depth of Binary Tree
 *
 * 迭代方式用层序遍历
 */
public class MaxDepth {
    public int maxDepthRecursive(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        } else{
            return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
        }
    }
}
