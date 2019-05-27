/**
 * created by Zheng Jiateng on 2019/5/27.
 */

/**
 * 268. Missing Number
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * 思路 0-9中缺8 用0-9与9个数字异或 剩下的数字就是只出现了一次的 就是原数组缺少的
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for(int i = 0; i < nums.length; i++){
            result = result ^ i ^ nums[i];
        }
        return result;
    }
}
