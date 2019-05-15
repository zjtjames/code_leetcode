/**
 * Created by Zheng Jiateng on 2019/5/15.
 */

/**
 * 11. Container With Most Water
 *
 * 左右各一指针，每次移动高度低的指针
 * 证明：hi <= hj时，area（i, j）是包含i的最大的面积，每次要被移动的指针，在本次循环都能得到包含它的最大面积，
 * 当两个指针相遇时，包含每个点的最大面积都被求出来过了
 * 双指针法，当单指针遍历时间复杂度太高时，想一想双指针法有没有奇效
 */
public class MaxArea__ {
    public int maxArea(int[] height) {
        // 双指针法
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left != right){
            int x = right - left;
            int hLeft = height[left];
            int hRight = height[right];
            int y = Math.min(hLeft, hRight);
            maxArea = Math.max(maxArea, x * y);
            if(hLeft < hRight){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
