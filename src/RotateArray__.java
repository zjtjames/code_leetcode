/**
 * created by Zheng Jiateng on 2019/6/1.
 */

/**
 * 189. Rotate Array
 *
 * 思路：技巧  firstly reverse all the elements of the array.
 * Then, reversing the first k elements followed by reversing the rest n-kn−k elements gives us the required result.
 * Original List                   : 1 2 3 4 5 6 7
 * After reversing all numbers     : 7 6 5 4 3 2 1
 * After reversing first k numbers : 5 6 7 4 3 2 1
 * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 */
public class RotateArray__ {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 1 || k < 1) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
    }
}
