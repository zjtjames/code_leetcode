/**
 * created by Zheng Jiateng on 2019/4/29.
 */

/**
 * 岛屿的数量 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1
 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3
 *
 * 思路：用DFS把相连的成一体的1都标成0
 */
public class NumIslands__ {
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m < 1){
            return 0;
        }
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    DFSMarkAsZero(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFSMarkAsZero(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        DFSMarkAsZero(grid, i +1, j);
        DFSMarkAsZero(grid, i -1, j);
        DFSMarkAsZero(grid, i, j + 1);
        DFSMarkAsZero(grid, i, j - 1);
    }
}