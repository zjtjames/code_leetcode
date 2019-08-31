/**
 * created by Zheng Jiateng on 2019/8/31.
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *  [3,5]
 * ]
 */
public class CombinationSum__ {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length < 1 || target < 0) return result;
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, 0, target, list);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> list){
        // 递归的第一步，是写递归的终止条件
        if(target < 0) return;
        if(target == 0) result.add(new ArrayList<>(list)); // 此处一定要深复制 否则会被删空
        else {
            // 我们是要求组成target的组合。因此需要一个循环来进行遍历。每遍历一次，将此数加入list，然后进行下一轮递归。
            for(int i = start; i < candidates.length; i++){ // 用start记录开始的位置 防止重复
                list.add(candidates[i]);
                backtrack(candidates, i, target - candidates[i], list);
                list.remove(list.size() - 1); // 每次递归完成，我们要进行一次回溯。把最新加的那个数删除
            }
        }
    }
}
