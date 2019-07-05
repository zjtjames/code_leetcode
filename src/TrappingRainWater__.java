/**
 * Created by Zheng Jiateng on 2019/7/5.
 */

/**
 * 42. Trapping Rain Water
 * 最多存多少雨水 与MaxArea_类似
 *
 * 思路：双指针法，一个从左往右，一个从右往左 O(n) O(1)
 * 假设从左往右开始走，只有右边最高处比左边最高处高，那么此指针处能储水量就与右边无关
 */
public class TrappingRainWater__ {
    public int trap(int[] height) {
        if (height == null || height.length < 1) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
