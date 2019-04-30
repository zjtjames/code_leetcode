/**
 * created by Zheng Jiateng on 2019/4/30.
 */

/**
 * 自定义的开平方根 69. Sqrt(x)
 */

public class MySqrt__ {
    public static int mySqrt(int x) {
        // 添加这个是为了防止下面出现除以0的错误
        if(x == 0){
            return 0;
        }
        int lo = 1;
        int hi = x;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            // 不能写成 mix * mid <=x 因为这在x很接近int表示上限时会超过int范围
            if(mid <= x / mid && (mid + 1) > x / (mid+1)){
                return mid;
            }
            if(mid > x / mid){
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
