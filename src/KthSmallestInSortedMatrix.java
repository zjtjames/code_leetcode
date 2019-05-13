/**
 * Created by Zheng Jiateng on 2019/5/13.
 */

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * n*n的矩阵 行列都按升序排列
 *
 * 把第一行构建成一个小顶堆，每次poll之后，把同列下一行的元素offer进小顶堆 做k-1次，再poll就是答案
 * 因此需要记录元素的行号列号
 * 原理：当x[i][j] 还没有出队的时候，x[i+1][j]不可能成为最小的，所以每次都offer同列下一行元素可行
 */
public class KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Elem> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Elem(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Elem elem = pq.poll();
            if (elem.row == n - 1) {
                continue;
            }
            pq.offer(new Elem(elem.row + 1, elem.column, matrix[elem.row + 1][elem.column]));
        }
        return pq.poll().val;
    }

    private class Elem implements Comparable<Elem> {
        int row;
        int column;
        int val;

        private Elem(int row, int column, int val) {
            this.row = row;
            this.column = column;
            this.val = val;
        }

        @Override
        public int compareTo(Elem o) {
            return this.val - o.val;
        }
    }
}
