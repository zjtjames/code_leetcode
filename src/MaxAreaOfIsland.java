/**
 * created by Zheng Jiateng on 2019/7/22.
 */

/**
 * 695. Max Area of Island
 * 与NumIslands一个做法 dfs
 */
public class MaxAreaOfIsland {
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if(m < 1) return 0;
        n = grid[0].length;
        if(n < 1) return 0;
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxArea = Math.max(maxArea, dfsMarkAsZero(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfsMarkAsZero(int[][] grid, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + dfsMarkAsZero(grid, i + 1, j) + dfsMarkAsZero(grid, i - 1, j) +
                dfsMarkAsZero(grid, i, j - 1) + dfsMarkAsZero(grid, i, j + 1);
    }
}
