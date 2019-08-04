/**
 * created by Zheng Jiateng on 2019/7/12.
 */

/**
 * 122. Best Time to Buy and Sell Stock II
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
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
