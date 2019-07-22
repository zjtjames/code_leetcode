/**
 * created by Zheng Jiateng on 2019/6/13.
 */

import java.util.Arrays;

/**
 * 33. Search in Rotated Sorted Array
 * 搜索旋转排序数组
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * 思路：先用二分查找的方法找到旋转点 再做两次二分查找
 * 一定要记住 java自带的bs hi是exclusive的 若没查到 返回的是应插入的位置
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len < 1) return -1;
        if(len == 1) return nums[0] == target ? 0 : -1;
        int pivot = findPivot(nums, 0, len - 1, len - 1);
        if (pivot < 0) {
            int index = Arrays.binarySearch(nums, 0, len, target);
            return index < 0 ? -1 : index;
        }
        int left = Arrays.binarySearch(nums, 0, pivot + 1, target);
        int right = Arrays.binarySearch(nums, pivot + 1, len, target);
        return left < 0 && right < 0 ? -1 : Math.max(left, right);
    }

    private int findPivot(int[] nums, int lo, int hi, int last){
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[mid + 1]) return mid;
            else if(nums[mid] > nums[last]) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

//    private int bs(int[] nums, int lo, int hi, int target){
//        if(lo > hi) return -1;
//        int mid = (lo + hi) / 2;
//        if(nums[mid] == target) return mid;
//        else if(nums[mid] > target) return bs(nums, lo, mid - 1, target);
//        else return bs(nums, mid + 1, hi, target);
//    }
}
