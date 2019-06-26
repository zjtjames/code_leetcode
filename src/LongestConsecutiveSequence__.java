/**
 * created by Zheng Jiateng on 2019/6/26.
 */

import java.util.HashSet;

/**
 * 128. Longest Consecutive Sequence
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Your algorithm should run in O(n) complexity.
 *
 * 思路：用HashSet把找数字的时间从o(n)降到o(1)
 * 当一个数字在set中找不到比它小1的数字时，说明它是一个连续序列的起始，只为这种数字做遍历
 */
public class LongestConsecutiveSequence__ {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int maxLength = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int length = 1;
                while(set.contains(num + 1)){
                    length++;
                    num++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
