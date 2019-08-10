/**
 * created by Zheng Jiateng on 2019/8/10.
 */
package dp_greedy;

/**
 * 276. 栅栏涂色
 * 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
 * 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个颜色相同。然后，返回所有有效涂色的方案数。
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k * k;
        int dp[] = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3; i <= n; i++){
            // i与i-1不同色的情况 + i与i-1同色的情况
            dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k-1);
        }
        return dp[n];
    }
}
