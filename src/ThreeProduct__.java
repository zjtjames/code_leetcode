/**
 * created by Zheng Jiateng on 2019/8/13.
 */

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，元素有正有负，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class ThreeProduct__ {
    public int maximumProduct(int[] nums) {
        //最大三个数相乘 或最小两个数和最大一个数相乘（一正两负）
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2){
                max3 = max2;
                max2 = num;
            } else if(num > max3){
                max3 = num;
            }

            if(num < min1){
                min2 = min1;
                min1 = num;
            }else if(num < min2){
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
