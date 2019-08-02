/**
 * created by Zheng Jiateng on 2019/5/7.
 */

/**
 * 169. Majority Element 找出一组数字序列中出现次数大于总数1/2的数字
 * 假设数组非空 且 majority element一定存在 The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * 摩尔投票法
 * 最基本的摩尔投票问题，找出一组数字序列中出现次数大于总数1/2的数字（并且假设这个数字一定存在）。
 * 显然这个数字只可能有一个。摩尔投票算法是基于这个事实：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
 * 最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个。
 * 所以我们的目标就是：删除，删除，删除。删到不能删除为止。
 */
public class MajorityElement__ {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                major = nums[i];
                count++;
            } else if(nums[i] == major){
                count++;
            } else{
                count--;
            }
        }
        return major;
    }
}
