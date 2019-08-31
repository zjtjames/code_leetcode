package backtrack; /**
 * created by Zheng Jiateng on 2019/5/11.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78.子集 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。说明：解集不能包含重复的子集。
 * Input: nums = [1,2,3]
 * Output:[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 * 回溯法(backtracking)的典型题 注意深复制
 */
public class Subsets__ {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1) return result;
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> list, int start) { // 记录start位置作为终止条件
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, i+ 1);
            list.remove(list.size() - 1);
        }
    }
}
