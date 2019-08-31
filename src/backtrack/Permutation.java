package backtrack; /**
 * created by Zheng Jiateng on 2019/5/9.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * Given a collection of distinct integers, return all possible permutations.
 * Input: [1,2,3]
 * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 * 回溯法(backtracking)的典型题 注意深复制
 */
public class Permutation {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length < 1) return result;
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) { // 递归先写终止条件
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(nums[i])) {
                    list.add(nums[i]);
                    backtrack(nums, list);
                    list.remove(list.size() - 1);
                }
            }
        } 
    }
}
