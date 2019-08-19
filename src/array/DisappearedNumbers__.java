package array;

/**
 * Created by Zheng Jiateng on 2019/8/19.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。不能使用辅助空间，时间复杂度为O(n)
 *
 * 思路：因为a[i]范围是1~n  所以a[i]-1的范围是0~n-1 恰好是数组索引的取值范围
 * 遇到一个数a[i] 就算出一个索引 a[i]-1 然后把该位置的数组取反 这样先走一遍
 * 第二遍走的时候 数字为正的位置+1 就是没出现过的数字
 */
public class DisappearedNumbers__ {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // 这里要取绝对值 因为这个位置上的值有可能已经被取反了
            if(nums[index] > 0) nums[index] = -nums[index]; // 小于0说明这个索引已经标记过 遇到重复数字了 不用再标记了
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) result.add(i+1);
        }
        return result;
    }
}
