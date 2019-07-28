/**
 * created by Zheng Jiateng on 2019/7/28.
 */
package dp_greedy;

/**
 * 221. 最大正方形
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Output: 4
 *
 * 思路：dp[i][j]表示以i,j为右下角的正方形的最大边长
 * 核心是递推公式： dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1.
 * 如果以i,j为右下角的正方形边长想到3，则i,j的左边，上边，左上角，都得是2，
 */
public class MaximalSquare__ {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row < 1) return 0;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int result = 0;
        for(int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(result, dp[i][0]);
        }
        for(int j = 0; j < column; j++) {
            dp[0][j] = matrix[0][j] - '0';
            result = Math.max(result, dp[0][j]);
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++){
                if(matrix[i][j] == '1') dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result; // 注意dp存的是边长 结果是面积
    }
}
