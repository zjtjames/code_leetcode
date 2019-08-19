/**
 * created by Zheng Jiateng on 2019/8/19.
 */
package array;

/**
 * 978. 最长湍流子数组
 * 比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。返回 A 的最大湍流子数组的长度。
 * 大小大小大
 * 思路:dp 但是不需要dp数组 只需要记录当前长度和上一个差值
 */
public class TurbulenceSize {
    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        if(len < 1) return 0;
        int result = 1;
        int length = 1;
        long lastDiff = 0;
        for(int i = 1; i < len; i++){
            long diff = A[i] - A[i - 1];
            if(diff == 0) length = 1;
            else if (lastDiff == 0 || diff * lastDiff > 0) length = 2;
            else length++;
            lastDiff = diff;
            result = Math.max(result, length);
        }
        return result;
    }
}
