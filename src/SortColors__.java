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
        int k = nums.length - 1;
        // 交换时，快指针指向0 慢指针指向1，交换的目的是把快指针遇到的优先级高的元素换到前面来,没遇到优先级高的元素就不换。
        // 慢指针在后面 快指针先遇到2的时候就把2甩到后面去了 所以慢指针只能指向1
        for(int i = 0; i <= k; i++){
            // 遇到优先级高的元素，快、慢指针都走；遇到优先级低的元素，只有快指针能走，所以慢指针自然指向优先级低的元素。
            if(nums[i] == 0){
                exchange(nums, i, slow++);
                // 把2甩到最后，减小数组长度，i回退1，使得可以再次检查从队尾换来的元素
            } else if(nums[i] == 2){
                exchange(nums, i--, k--);
            }
        }
    }

    private void exchange(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
