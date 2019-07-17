/**
 * created by Zheng Jiateng on 2019/5/10.
 */

/**
 * 238. Product of Array Except Self 除了自己之外的数字的乘积
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 要求 o(n)的时间复杂度和0(1)的空间复杂度 The output array does not count as extra space for the purpose of space complexity analysis.
 *
 * 思路：除了自己之外的数字的乘积= 自己左边的数的乘积 * 自己右边的数的乘积
 * 从左到右走一遍，再从右到左走一遍
 */
public class ProductExceptSelf__ {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for(int i = 1; i < n; i++){
            output[i] = output[i-1] * nums[i-1]; // 此时output[i]表示i左边的乘积
        }
        int right = 1;
        for(int i = n-1; i >= 0; i--){
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
