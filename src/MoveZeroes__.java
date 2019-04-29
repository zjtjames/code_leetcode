/**
 * created by Zheng Jiateng on 2019/4/29.
 */

/**
 * 最少的次数把零移到数组最后，非零元素相对位置不变 .283. Move Zeroes
 *
 * 双指针法 一个快指针 一个慢指针
 * 慢指针之前都是非零元素，快指针和慢指针之间都是零
 * 快指针遇到非零元素，交换快慢指针所指元素，慢指针加1
 * 交换的时候只有两种情况 1.快慢指针一定都指向零 2.快指针非零，慢指针零
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


