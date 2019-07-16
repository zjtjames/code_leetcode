/**
 * created by Zheng Jiateng on 2019/7/16.
 */

/**
 * 63. Unique Paths II
 * 路上有路障
 *
 * 思路：有路障的格子不应该对路径数量做出任何贡献 所以该格应该设为0
 * dp矩阵就用题目给的障碍物矩阵 所以空间复杂度为o(1)
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        // 遍历第一列 如果一格值为0 则把它的值设为与上一格相同
        for (int i = 1; i < row; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < column; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[row - 1][column - 1];
    }
}
