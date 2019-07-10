/**
 * created by Zheng Jiateng on 2019/4/29.
 */

/**
 * 按0,1,2的顺序排列数组 75. Sort Colors
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * 加强版的MoveZeroes 也是快慢指针，只是再增加第三个指针，把2甩到最后，减小数组长度，i回退1，使得可以再次检查从队尾换来的元素
 * 慢指针指向要被换到后面的元素
 */
public class SortColors__ {

    public void sortColors(int[] nums) {
        int slow = 0;
        int last = nums.length - 1;
        for(int i = 0; i <= last; i++){
            // 把2甩到最后，减小数组长度，i回退1，使得可以再次检查从队尾换来的元素
            if(nums[i] == 2){
                exchange(nums, i--, last--);
                // 与MoveZeroers完全一样 把1换到后面去 遇到0就交换
            } else if(nums[i] == 0){
                exchange(nums, i, slow++);
            }
        }
    }

    private void exchange(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
