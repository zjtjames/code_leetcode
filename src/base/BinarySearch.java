/**
 * created by Zheng Jiateng on 2019/4/28.
 */
package base;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int bs(int[] arrays, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arrays[mid] == target) {
                return mid;
            }
            if (arrays[mid] > target) {
                return bs(arrays, target, lo, mid - 1);
            } else {
                return bs(arrays, target, mid + 1, hi);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 9, 11, 15};
        System.out.println(bs(a, 4, 0, a.length - 1));
    }
}
