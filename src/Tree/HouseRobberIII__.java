/**
 * created by Zheng Jiateng on 2019/8/22.
 */
package Tree;

import base.TreeNode;

/**
 * 337. 打家劫舍 III 树形dp典型题
 * 这个地方的所有房屋的排列类似于一棵二叉树。如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 思路：对于每个根结点来说，有两种情况，包含此根结点和不包含
 * 树的题一般都是递归，用与解决原树相同的方法解决左子树和右子树
 */
public class HouseRobberIII__ {
    // 树形dp 用一个数组表示不包含根结点和包含根结点最大值
    public int rob(TreeNode root) {
        int[] dp = core(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] core(TreeNode root){
        int[] dp = new int[2]; // dp[0]表示不包含根结点的最大值 dp[1]表示包含根结点
        if(root == null) return dp;
        int[] left = core(root.left);
        int[] right = core(root.right);
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}
