/**
 * created by Zheng Jiateng on 2019/7/12.
 */

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * 思路：在MaxProfit的基础上稍作修改即可
 */
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        int buy = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > buy){
                profit += prices[i] - buy;
                buy = prices[i];
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }
}
