/**
 * created by Zheng Jiateng on 2019/5/7.
 */

/**
 * 找出一组数字序列中出现次数大于总数1/2的数字 169. Majority Element
 * 假设数组非空 且 majority element一定存在 The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 */
public class MajorityElement {
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
