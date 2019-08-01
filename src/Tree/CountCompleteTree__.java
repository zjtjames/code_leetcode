/**
 * created by Zheng Jiateng on 2019/8/1.
 */
package Tree;

import base.TreeNode;

/**
 * 222. Count Complete Tree Nodes 计算完全二叉树的结点数量
 *
 * Input:
 *      1
 *     / \
 *    2   3
 *   / \  /
 *  4  5 6

 Output: 6
 *
 * 思路：用深度
 * 1.完全二叉树深度只需要看左子树
 * 2.完全二叉树的左右子树一定有一个是完美二叉树，另一个还是完全二叉树。判断的依据是右子树的高度是不是等于总高度-1，如果是，那个左子树是一个
 * 完美二叉树，如果不是，右子树是一个完美二叉树
 * 3.用位运算可以替代2的次幂计算
 */
public class CountCompleteTree__ {
    // 递归写法
    public int countNodesRecursive(TreeNode root) {
        int d = depth(root);
        if(d == -1) return 0;
        // 用位运算可以替代2的次幂计算
        // 完全二叉树的左右子树，一个是完美二叉树，一个是完全二叉树
        return depth(root.right) == d - 1 ? (1 << d) + countNodesRecursive(root.right) : (1 << d-1) + countNodesRecursive(root.left);
    }

    // 迭代写法
    public int countNodesIterative(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        int d = depth(root);
        while (root != null) {
            if (depth(root.right) == d - 1) {
                count += 1 << d;
                root = root.right;
            } else {
                count += 1 << d - 1;
                root = root.left;
            }
            d--;
        }
        return count;
    }

    // 完全二叉树求深度 只看左子树即可
    private int depth(TreeNode root){
        return root == null ? -1 : 1 + depth(root.left);
    }
}
