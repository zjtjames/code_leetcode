/**
 * created by Zheng Jiateng on 2019/4/29.
 */

/**
 * 找出数组中唯一一个只出现了一次的数字 136. Single Number
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
