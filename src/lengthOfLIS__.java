/**
 * created by Zheng Jiateng on 2019/4/27.
 */

import java.util.Arrays;

/**
 * 最长增长序列 300. Longest Increasing Subsequence
 */
public class lengthOfLIS__ {
    /**
     * dp o(n2) dp[i]表示包含nums[i]元素的最长增长子序列的长度
     */
    public static int lengthOfLIS_n2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int maxResult = 1;
        for(int i = 1; i < len; i++){
            int maxval = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxResult = Math.max(maxResult, dp[i]);
        }
        return maxResult;
    }

    /**
     * dp + bs
     * 更小的数有更高的优先级 可以覆盖更大的数
     */
    public static int lengthOfLIS_nlogn(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                // 算出来的i为第一个比它大的数的位置 也是它应该被插入的位置
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(Arrays.binarySearch(a, 0, 0,2));
    }

}
