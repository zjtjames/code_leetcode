/**
 * created by Zheng Jiateng on 2019/5/16.
 */

import base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 用先序和中序遍历序列重建二叉树
 *
 * 递归的每一层先建立root，再判断是否有左右子树，从而给root.left，root.right赋值
 */
public class BuildTreeFromPreAndIn__ {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        if(preorder.length == 1){
            return root;
        }
        int rootIndexInorder = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIndexInorder = i;
                break;
            }
        }
        // 如果有左子树
        if(rootIndexInorder != 0){
            int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndexInorder);
            int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
            root.left = buildTree(preLeft, inLeft);
        }
        // 如果有右子树
        if(rootIndexInorder != inorder.length -1){
            int[] inRight = Arrays.copyOfRange(inorder, rootIndexInorder + 1, inorder.length);
            int[] preRight = Arrays.copyOfRange(preorder, 1 + rootIndexInorder, preorder.length); // 注意这一行
            root.right = buildTree(preRight, inRight);
        }
        return root;
    }
}
