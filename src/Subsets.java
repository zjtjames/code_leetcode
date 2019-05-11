/**
 * created by Zheng Jiateng on 2019/5/11.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 78. Subsets
 *
 * 回溯法(backtracking)的典型题
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
        result.add(new ArrayList(tempList));
        for(int i = start; i < nums.length; i++){ // 这个for循环是精髓
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1); // 在这一步进行回溯
        }

    }
}
