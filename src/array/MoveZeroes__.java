package array; /**
 * created by Zheng Jiateng on 2019/4/29.
 */

/**
 * 283. Move Zeroes
 * 最少的次数把零移到数组最后，非零元素相对位置不变
 *
 * 思路：
 * 双指针法 一个快指针 一个慢指针
 * 快指针遇到非零元素 交换快慢指针所指元素 快慢指针都加1
 * 快指针遇到零 快指针依然加1 慢指针被卡住不动
 */
public class MoveZeroes__ {

    public void moveZeroes(int[] nums) {
        for (int i = 0, slow = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                exchange(nums, i, slow++);
            }
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


