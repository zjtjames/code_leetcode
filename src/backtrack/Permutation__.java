package backtrack; /**
 * created by Zheng Jiateng on 2019/5/9.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations 排列
 * Given a collection of distinct integers, return all possible permutations.
 * Input: [1,2,3]
 * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 * 回溯法(backtracking)的典型题 注意深复制
 */
public class Permutation__ {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 不必要
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // 万分注意 此处一定要用深复制 否则因为回溯 temp的元素都被删掉了 最后result里全是空list
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue; // 元素已经包含 跳过
                }
                tempList.add(nums[i]);
                backtrack(result, tempList, nums); // 通过递归，把当前位是这个数字的所有情况都罗列完 然后回溯，即删掉当前位，进入for循环的下一个数字
                tempList.remove(tempList.size() - 1); // 这一位是当前数字的所有情况罗列完后 删除这一位的这个数字 进入for循环的下一个数字
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);

    }
}
