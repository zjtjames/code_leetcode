package backtrack; /**
 * created by Zheng Jiateng on 2019/5/11.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 78. backtrack.Subsets The solution set must not contain duplicate subsets.
 * Input: nums = [1,2,3]
 * Output:[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 * 回溯法(backtracking)的典型题 注意深复制
 */
public class Subsets__ {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
        result.add(new ArrayList(tempList)); // 万分注意 此处一定要用深复制 否则因为回溯 tempList的元素都被删掉了 最后result里全是空list
        for(int i = start; i < nums.length; i++){ // 这个for循环是精髓
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1); // 通过递归，把当前位是这个数字的所有情况都罗列完 然后回溯，即删掉当前位，进入for循环的下一个数字
            tempList.remove(tempList.size() - 1); // 在这一步进行回溯
        }
    }
}
