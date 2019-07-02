/**
 * Created by Zheng Jiateng on 2019/6/28.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum 和为0的三个数字的所有情况
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4], The solution set must not contain duplicate triplets.
 * A solution set is:
 * [[-1, 0, 1],[-1, -1, 2]]
 *
 * 思路：先对数组排序 然后每选定一个数字 对右边数组做两头寻找版的two sum
 * 时间复杂度o(n2)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len < 3) return result;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i -1]) continue;
            int target = 0 - nums[i];
            int lo = i + 1;
            int hi = len - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> oneAnswer = new ArrayList<>();
                    oneAnswer.add(nums[i]);
                    oneAnswer.add(nums[lo]);
                    oneAnswer.add(nums[hi]);
                    result.add(new ArrayList<>(oneAnswer));
                    break;
                } else if (nums[lo] + nums[hi] > target) {
                    hi--;
                } else lo++;
            }
        }
        return result;
    }
}
