package Tree;

/**
 * Created by Zheng Jiateng on 2019/8/19.
 */

import base.TreeNode;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 思路：递归地求每棵树左子树深度+右子树深度
 */
public class LongestPathOfBinaryTree {
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}
