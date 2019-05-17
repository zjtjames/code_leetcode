/**
 * Created by Zheng Jiateng on 2019/5/18.
 */

/**
 * 88. Merge Sorted Array 归并两个排序数组 不能使用辅助空间 结果存在nums1里面
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 *
 * 精髓：从后往前放
 */
public class MergeWithoutExtraSpace__ {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从后往前放
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            } else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}
