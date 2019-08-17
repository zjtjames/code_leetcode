package array; /**
 * created by Zheng Jiateng on 2019/5/14.
 */

/**
 * 将矩阵顺时针旋转90度 48. Rotate Image
 *
 * 旋转问题解法：先交换行，再转置矩阵：转置矩阵就是交换a[i][j]与a[j][i] 主对角线是从左上到右下
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n < 2){
            return;
        }
        //先交换行
        for(int i = 0; i < n / 2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = tmp;
        }
        // 再转置矩阵: 转置矩阵就是交换a[i][j]与a[j][i] 主对角线是从左上到右下
        for(int i = 0; i< n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
