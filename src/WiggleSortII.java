import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * created by Zheng Jiateng on 2019/7/10.
 */

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        pq.offer(2);
        pq.poll();
    }
}
