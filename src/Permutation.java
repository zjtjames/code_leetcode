/**
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
 * 回溯法(backtracking)的典型题
 */
public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 不必要
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // 深复制
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue; // 元素已经包含 跳过
                }
                tempList.add(nums[i]);
                backtrack(result, tempList, nums); // 因为for循环的存在 每次回溯可以把下一位的可能的结果都包括上
                tempList.remove(tempList.size() - 1); // 这一位的这个数字所有情况罗列完后 删除这一位的这个数字 进入for循环的下一个数字
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}
