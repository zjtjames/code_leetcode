/**
 * created by Zheng Jiateng on 2019/6/20.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix 顺时针打印矩阵
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 思路：每一圈的起点都在主对角线上 记为(start, start)
 */
public class SpiralOrder__ {
    private ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return result;
        int rows = matrix.length;
        if (rows < 1) return result;
        int columns = matrix[0].length;
        int start = 0;
        // 开始新一圈的条件是start * 2 < rows 并且 start * 2 < columns 这是精髓
        while (start * 2 < rows && start * 2 < columns) {
            OneCircle(matrix, rows, columns, start++);
        }
        return result;
    }

    // 走一圈 每一步的条件要比上一步严格
    private void OneCircle(int[][] matrix, int rows, int columns, int start) {
        // 这两个值要记住 第一遍做的时候写错了
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 第一步 从左到右打印一行 只要能开始新一圈 第一步总是无条件的
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }

        // 第二步 从上到下打印一列 条件是终止行号大于起始行号
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) { // 注意不能重复打印 所以起始是start+1 要加1
                result.add(matrix[i][endX]);
            }
        }

        // 第三步 从右到左打印一行 条件是圈内至少有两行两列
        if (endX > start && endY > start) {
            for (int i = endX - 1; i >= start; i--) { // 注意是i--不是++
                result.add(matrix[endY][i]);
            }
        }

        // 第四步 从下到上打印一列 条件是圈内至少有三行两列
        if (endX > start  && endY > start + 1) {
            for (int i = endY - 1; i > start; i--) { // 注意是i--不是++  endY要-1 i要>而不是>=  因为不能重复
                result.add(matrix[i][start]);
            }
        }
    }
}
