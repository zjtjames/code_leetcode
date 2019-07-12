/**
 * created by Zheng Jiateng on 2019/4/28.
 */
package base;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] arrays, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if(arrays[mid] == target) return mid;
            else if(arrays[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }

//    public static int binarySearch(int[] nums, int lo, int hi, int target){
//        if(lo > hi) return -1;
//        int mid = (lo + hi) / 2;
//        if(nums[mid] == target) return mid;
//        else if(nums[mid] > target) return binarySearch(nums, lo, mid - 1, target);
//        else return binarySearch(nums, mid + 1, hi, target);
//    }

    public static void main(String[] args) {
        int[] a = {4, 5, 9, 11, 15};
        System.out.println(binarySearch(a, 11, 0, 4));
    }
}
