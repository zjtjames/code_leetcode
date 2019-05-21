/**
 * Created by Zheng Jiateng on 2019/5/18.
 */

/**
 * 73. Set Matrix Zeroes 要求 Time Complexity : O(M×N)  Space Complexity : O(1)
 *
 * 利用第一行和第一列当flag 走两遍 第一遍定flag 第二遍根据flag设0
 */
public class SetZeroes__ {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m < 1) return;
        int n = matrix[0].length;
        boolean firstColumn = false;
        // 每一个cell用0,j和i,0做标记
        // 第一列需要一个额外的标记，以与第一行区分
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0) firstColumn = true;
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据第一行和第一列的标记，把第二行第二列开始应变成0的点都变成0
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 变第一行
        if(matrix[0][0] == 0){
            for(int j = 1; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        // 变第一列
        if(firstColumn){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
