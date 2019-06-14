/**
 * created by Zheng Jiateng on 2019/6/14.
 */

/**
 * 79. Word Search
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * 思路：回溯法 递归
 */
public class WordSearch__ {
    int len;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (board == null || rows < 1 || word == null) return false;
        int columns = board[0].length;
        visited = new boolean[rows][columns];
        len = word.length();
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (hasPathcore(board, rows, columns, i, j, word, pathLength)) return true;
            }
        }
        return false;
    }

    private boolean hasPathcore(char[][] board, int rows, int columns, int row, int column, String word, int pathLength) {
        if (pathLength == len) return true;
        boolean hasPath = false; // 精髓 回溯的判断依据
        if (row >=0 && row < rows && column >=0 && column < columns && !visited[row][column] && board[row][column] == word.charAt(pathLength++)){
            visited[row][column] = true;
            // 上下左右
            hasPath = hasPathcore(board, rows, columns, row - 1, column, word, pathLength) ||
                    hasPathcore(board, rows, columns, row + 1, column, word, pathLength) ||
                    hasPathcore(board, rows, columns, row, column - 1, word, pathLength) ||
                    hasPathcore(board, rows, columns, row, column + 1, word, pathLength);
            if (!hasPath) {
                pathLength--;
                visited[row][column] = false;
            }
        }
        return hasPath;
    }
}
