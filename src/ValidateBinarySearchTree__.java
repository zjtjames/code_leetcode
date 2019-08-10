/**
 * created by Zheng Jiateng on 2019/6/22.
 */

import base.TreeNode;

import java.util.ArrayList;

/**
 * 98. Validate Binary Search Tree
 * 验证二叉搜索树
 * 一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 思路：递归时加两个参数upper和lower 记录此结点值的上界和下界
 * 首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程
 */
public class ValidateBinarySearchTree__ {
    public boolean isValidBST(TreeNode root) {
        return core(root, null, null);
    }

    private boolean core(TreeNode root, Integer lower, Integer upper) {
        if(root == null) return true;
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!core(root.right, val, upper)) return false;
        if (!core(root.left, lower, val)) return false;
        return true;
    }
}
