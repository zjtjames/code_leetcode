package Tree;

/**
 * Created by Zheng Jiateng on 2019/8/19.
 */

import base.TreeNode;

/**
 * 226. 翻转二叉树
 * 循环做法：queue 层序遍历
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
