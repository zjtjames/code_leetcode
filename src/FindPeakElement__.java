/**
 * created by Zheng Jiateng on 2019/7/8.
 */

/**
 * 162. Find Peak Element
 * 寻找极大值 要求对数时间复杂度 nums[-1] = nums[n] = -∞
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * 思路：类二分查找 发现一个数在上升区间（比右边小），说明峰值在他右边（不含自身）；
 * 发现一个数在下降区间（比右边大），说明峰值在他左边（含自身）
 * 最后停止的时候 lo=hi就停在峰值处
 */

public class FindPeakElement__ {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[mid + 1]) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
