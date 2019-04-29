/**
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
        int[][] products = new int[n][m];
        // 要到products[n-1][m-1]
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == 0 && j == 0){
                    products[i][j] = 0;
                }
                else if(i == 0 && j > 0){
                    products[i][j]  = 1;
                }
                else if(i > 0 && j == 0){
                    products[i][j] = 1;
                } else{
                    products[i][j] = products[i][j-1] + products[i-1][j];
                }
            }
        }
        products[0][0] = 1;
        return products[n-1][m-1];
    }
}
