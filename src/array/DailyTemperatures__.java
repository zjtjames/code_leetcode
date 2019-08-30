package array;

/**
 * Created by Zheng Jiateng on 2019/8/31.
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 思路：与239. 滑动窗口最大值 时间复杂度o(n)一样 用双向队列建立单调递减队列
 * 从后向前遍历 要保持队列单调递减 每次移除所有比当前元素小的元素 因为被当前元素“压扁了” 之后用不上了 只保留比当前元素大的
 * 只有比当前元素大的之后才有可能被用上
 */
public class DailyTemperatures__ {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length < 1) return new int[0];
        Deque<Integer> indexDeque = new LinkedList<>();
        int[] result = new int[T.length];
        for(int i = T.length - 1; i >= 0; i--){
            while(!indexDeque.isEmpty() && T[i] >= T[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            if(indexDeque.isEmpty()) result[i] = 0;
            else result[i] = indexDeque.getLast() - i;
            indexDeque.addLast(i);
        }
        return result;
    }
}
