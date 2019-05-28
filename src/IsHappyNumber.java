/**
 * created by Zheng Jiateng on 2019/5/28.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 *
 * 思路：set.add()方法的返回值是boolean型的 要插入set中已有元素时返回false
 */
public class IsHappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            if(n == 1){
                return true;
            }
            int sum = 0;
            while(n != 0){
                int digit = (n % 10);
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return false;
    }
}
