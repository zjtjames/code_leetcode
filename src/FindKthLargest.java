/**
 * created by Zheng Jiateng on 2019/5/14.
 */

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 *
 * 小顶堆
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(pq.size() < k){
                pq.offer(num);
            } else if(num >= pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}
