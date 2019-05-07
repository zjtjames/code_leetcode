/**
 * created by Zheng Jiateng on 2019/5/7.
 */

/**
 * 279. Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * Example 1:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * 思路：dp
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = 1;
            } else {
                double sq = Math.sqrt(i);
                if(sq == (int)sq){
                    dp[i] = 1;
                } else{
                    int min = i;
                    for(int j = 1; j<= (int)sq; j++){
                        int num = dp[j*j] + dp[i - j*j];
                        min = Math.min(min, num);
                    }
                    dp[i] = min;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(2 == 2.0);
    }
}
