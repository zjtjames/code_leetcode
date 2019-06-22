/**
 * created by Zheng Jiateng on 2019/6/22.
 */

import base.TreeNode;

import java.util.ArrayList;

/**
 * 98. Validate Binary Search Tree
 * 验证二叉搜索树
 *
 * 思路：中序遍历
 */
public class ValidateBinarySearchTree {
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
}
