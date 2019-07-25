/**
 * created by Zheng Jiateng on 2019/7/25.
 */
package Tree;

import base.TreeNode;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len < 1) return null;
        TreeNode root = new TreeNode(nums[len / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, len / 2 + 1, len));
        return root;
    }
}
