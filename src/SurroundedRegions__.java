/**
 * created by Zheng Jiateng on 2019/7/7.
 */

/**
 * 130. Surrounded Regions
 * 与NumIslands__(200. Number of Islands)类似解法
 * DFS 在边界的O往里救里面的O
 *
 */
public class SurroundedRegions__ {
    private int m;
    private int n;

    public void solve(char[][] board) {
        m = board.length;
        if(m < 3) return;
        n = board[0].length;
        if(n < 3) return;
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') board[i][0] = 'S';
            if(board[i][n - 1] == 'O') board[i][n - 1] = 'S';
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') board[0][j] = 'S';
            if(board[m - 1][j] == 'O') board[m - 1][j] = 'S';
        }

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'S') dfsSaveO(board, i, 1);
            if(board[i][n - 1] == 'S') dfsSaveO(board, i, n-2);
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'S') dfsSaveO(board, 1, j);
            if(board[m - 1][j] == 'S') dfsSaveO(board, m - 2, j);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'S') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private void dfsSaveO(char[][] board, int i, int j){
        if(i < 1 || j < 1 || i >= m - 1 || j >= n - 1 || board[i][j] != 'O') return;
        if(board[i+1][j] == 'S' || board[i - 1][j] == 'S' || board[i][j + 1] == 'S' || board[i][j - 1] == 'S') board[i][j] = 'S';
        else board[i][j] = 'X';
        dfsSaveO(board, i + 1, j);
        dfsSaveO(board, i - 1, j);
        dfsSaveO(board, i, j + 1);
        dfsSaveO(board, i, j - 1);

    }
}
