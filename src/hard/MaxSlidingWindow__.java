/**
 * created by Zheng Jiateng on 2019/8/8.
 */
package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值 时间复杂度o(n)
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * 思路：双向队列 队列中存数组的索引
 * 每当要新加入一个数字时，清理双向队列：移除比当前元素小的所有元素，它们不可能是最大的。
 * （你可以想象，加入数字的大小代表人的体重，把前面体重不足的都压扁了，直到遇到更大的量级才停住。）
 * 然后将当前元素添加到双向队列中。
 * 然后将 deque[0] 添加到输出中。双向队列最左边的元素就是最大值
 */
public class MaxSlidingWindow__ {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1 || k < 1) return new int[0];
        int[] result = new int[nums.length - k + 1];
        int cur = 0;
        // 存数组中的索引
        Deque<Integer> indexDeque = new LinkedList<>();
        for(int i = 0; i < k - 1; i++){
            while(!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
        for(int i = k - 1; i < nums.length; i++){
            while(!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            // 判断最左边的元素是否因窗口大小该移除了
            if(i - indexDeque.getFirst() == k) indexDeque.removeFirst();
            result[cur++] = nums[indexDeque.getFirst()];
        }
        return result;
    }
}
