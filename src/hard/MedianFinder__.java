/**
 * created by Zheng Jiateng on 2019/8/5.
 */
package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 *
 * 思路：建两个堆，一个大顶堆，一个小顶堆
 * 大顶堆存较小的那一半数字
 * 小顶堆存较大的那一半数字
 * 第奇数个数字入小顶堆 但要先入大顶堆 然后取堆顶元素入小顶堆 以保证小顶堆所有元素都大于大顶堆
 * 第偶数个数字入大顶堆 但要先入小顶堆 然后取堆顶元素入大顶堆 以保证大顶堆所有元素都小于小顶堆
 */
public class MedianFinder__ {
    PriorityQueue<Integer> maxPQ; // 大顶堆存较小的那一半数字
    PriorityQueue<Integer> minPQ; // 小顶堆存较大的那一半数字

    /** initialize your data structure here. */
    public MedianFinder__() {
        maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        minPQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int size = maxPQ.size() + minPQ.size();
        if (size == 0) minPQ.offer(num);
        else if ((size & 1) == 1) {
            minPQ.offer(num);
            maxPQ.offer(minPQ.poll());
        } else {
            maxPQ.offer(num);
            minPQ.offer(maxPQ.poll());
        }
    }

    public double findMedian() {
        int size = maxPQ.size() + minPQ.size();
        if ((size & 1) == 1) {
            return minPQ.peek();
        } else {
            return ((double)maxPQ.peek() + (double)minPQ.peek()) / 2;
        }
    }
}
