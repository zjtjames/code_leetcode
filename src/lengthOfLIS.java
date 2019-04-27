/**
 * created by Zheng Jiateng on 2019/4/27.
 */

/**
 * 最长增长序列 300. Longest Increasing Subsequence
 */
public class lengthOfLIS {
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

    public static void main(String[] args) {
        int[] a = {2,3,4,1,5};
        lengthOfLIS(a);
    }
}
