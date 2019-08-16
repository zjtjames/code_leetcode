/**
 * created by Zheng Jiateng on 2019/7/25.
 */
package Tree;

import base.TreeNode;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 思路：不用每次复制数组 移动lo hi两个指针即可
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return core(nums, 0, nums.length - 1);
    }

    private TreeNode core(int[] nums, int lo, int hi){
        if(lo <= hi ){
            int mid = (lo + hi) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = core(nums, lo, mid - 1);
            root.right = core(nums, mid + 1, hi);
            return root;
        }
        return null;
    }
}
