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
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        if (x < 1) return false;
        int y = board[0].length;
        boolean[][] visit = new boolean[x][y];

    }
}
