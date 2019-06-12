/**
 * created by Zheng Jiateng on 2019/6/12.
 */

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 二分查找 有重复元素 返回重复元素的起始终止索引 要求 O(log n)
 *
 * 思路：二分查找一个元素后 往左和右继续二分查找
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] result = {-1, -1};
        if(len < 1) return result;
        int one = binarySearch(nums, 0, len - 1, target);
        if(one == -1) return result;
        int left = one;
        int right = one;
        while (left >= 1) {
            int tmp = binarySearch(nums, 0, left - 1, target);
            if (tmp == -1) break;
            left = tmp;
        }
        while (right <= len - 1) {
            int tmp = binarySearch(nums, right + 1, len - 1, target);
            if (tmp == -1) break;
            right = tmp;
        }
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target){
        if(lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return binarySearch(nums, lo, mid - 1, target);
        else return binarySearch(nums, mid + 1, hi, target);
    }
}
