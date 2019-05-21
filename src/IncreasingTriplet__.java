/**
 * Created by Zheng Jiateng on 2019/5/19.
 */

/**
 * 334. Increasing Triplet Subsequence
 * Return true if there exists i, j, k, such that arr[i] < arr[j] < arr[k]
 */
public class IncreasingTriplet__ {
    public boolean increasingTriplet(int[] nums) {
        // 其实就是找第一个大于前面两个数的数，与后面的数无关，在线处理
        // 设两个最大的数
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= first){ // 这里必须要带等于，防止1,1,1被判true
                first = num;
            }else if (num <= second){
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
