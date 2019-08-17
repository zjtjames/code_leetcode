/**
 * created by Zheng Jiateng on 2019/8/10.
 */
package hard;

import java.util.Arrays;

/**
 * 265. 粉刷房子 II 时间复杂度O(nk)
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成k种颜色中的一种，
 * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
 * 每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；
 * costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 *
 * 思路：用与256. 粉刷房子完全一样的dp思路，可以轻易得到O(nk^2)的方法
 *
 */
public class PaintHoustII {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n < 1) return 0;
        int k = costs[0].length;
        int[][] dp = new int[n][k]; // dp[i][j]表示第i个房子涂成j色的总成本
        int[] aux = new int[4]; // aux[0]为最小值索引，aux[1]为最小值
        aux[1] = Integer.MAX_VALUE;
        aux[3] = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
            if(dp[0][j] < aux[1]){
                aux[2] = aux[0];
                aux[3] = aux[1];
                aux[0] = j;
                aux[1] = dp[0][j];
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < k; j++){
                // 如果j恰好是dp[i-1]中最小值的索引 则要取次小值
                // 如果j不是dp[i-1]中最小值的索引 则要取最小值
                // 所以记录最小值和次小值的值与索引
                if(j == aux[0]){
                    dp[i][j] = aux[3] + costs[i][j];
                } else{
                    dp[i][j] = aux[1] + costs[i][j];
                }
                if (dp[i][j] < aux[1]) {
                    aux[2] = aux[0];
                    aux[3] = aux[1];
                    aux[0] = j;
                    aux[1] = dp[0][j];
                }
            }
        }
        return aux[1];
    }
}
