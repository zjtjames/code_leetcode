/**
 * Created by Zheng Jiateng on 2019/5/15.
 */

/**
 * 11. Container With Most Water
 *
 * 双指针法，当单指针遍历时间复杂度太高时，想一想双指针法有没有奇效
 */
public class MaxArea {
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
