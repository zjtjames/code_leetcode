package dp_greedy; /**
 * created by Zheng Jiateng on 2019/4/11.
 */

/**
 * 62. Unique Paths
 * 动态规划：任意格子的走法等于它上边格子的走法和左边格子的走法之和
 */
public class UniquePaths__ {
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1){
            return 0;
        }
        int[][] dp = new int[n][m];
        // 要到products[n-1][m-1]
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else if(i == 0 && j > 0){
                    dp[i][j]  = 1;
                }
                else if(i > 0 && j == 0){
                    dp[i][j] = 1;
                } else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
