/**
 * created by Zheng Jiateng on 2019/5/10.
 */

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements. 347. Top K Frequent Elements
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        for (int num : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (map.get(num) > map.get(pq.peek())) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
