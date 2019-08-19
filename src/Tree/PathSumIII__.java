package Tree;

/**
 * Created by Zheng Jiateng on 2019/8/20.
 */

import base.TreeNode;

/**
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 思路：学会递归地思考问题
 * 写递归的技巧是：明白一个函数的作用并相信它能完成这个任务，千万不要跳进这个函数里面企图探究更多细节，否则就会陷入无穷的细节无法自拔。
 */
public class PathSumIII__ {
    // 计算根为root的树中的路径数量，3种情况，以root为头，不以root为头（又可分为2种情况，左子树的路径数量，右子树的路径数量）
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int startFromRoot = countStartFrom(root, sum);
        int leftSum = pathSum(root.left, sum);
        int rightSum = pathSum(root.right, sum);
        return startFromRoot + leftSum + rightSum;
    }

    // 计算以root为头的路径数量
    private int countStartFrom(TreeNode root, int sum){
        if(root == null) return 0;
        int itself = root.val == sum ? 1 : 0;
        int leftCount = countStartFrom(root.left, sum - root.val);
        int rightCount = countStartFrom(root.right, sum - root.val);
        return itself + leftCount + rightCount;
    }
}
