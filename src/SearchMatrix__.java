/**
 * created by Zheng Jiateng on 2019/5/16.
 */

/**
 * 240. Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * 从右上角开始搜索，若target比当前位置元素大，就下降一行，因为当前行往左越来越小；
 * 若target比当前位置元素小，就左移一列，因为当前列往下越来越大；
 * 每次移动排除一行或者一列，所以时间复杂度为O(m+n)
 */
public class SearchMatrix__ {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m < 1){
            return false;
        }
        int n = matrix[0].length;
        if(n < 1){
            return false;
        }
        int row = 0;
        int column = n - 1;
        while(row <= m - 1 && column >= 0){
            if(target == matrix[row][column]){
                return true;
            } else if(target > matrix[row][column]){
                row++;
            } else{
                column--;
            }
        }
        return false;
    }
}
