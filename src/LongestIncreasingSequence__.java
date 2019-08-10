/**
 * created by Zheng Jiateng on 2019/4/27.
 */

import java.util.Arrays;

/**
 * 最长增长序列 300. Longest Increasing Subsequence
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSequence__ {
    /**
     * dp o(n^2) dp[i]表示包含nums[i]元素的最长增长子序列的长度
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
     * 0 8 6 12 2 3 4 5
     * 0
     * 0 8
     * 0 6
     * 0 6 12
     * 0 2 12
     * 0 2 3
     * 0 2 3 4
     * 0 2 3 4 5
     *
     * 0 8 4 12 2 3
     * 0
     * 0 8
     * 0 4
     * 0 4 12
     * 0 2 12 此时虽然不是一个LIS 但是不影响结果 即len
     * 0 2 3  0 2 3的优先级高于 0 4 12
     */
    public static int lengthOfLIS_nlogn(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                // 算出来的i为第一个比它大的数的位置 也是它应该被插入的位置 如果key比a中所有元素都大，则返回toIndex 此函数的toIndex是exclusive的
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
