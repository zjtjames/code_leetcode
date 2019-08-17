package dp_greedy; /**
 * created by Zheng Jiateng on 2019/5/27.
 */

/**
 * 121. Best Time to Buy and Sell Stock
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * O(n)
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1){
            return 0;
        }
        int buy = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else if(prices[i] - buy > maxProfit){ // 这个else很重要 一定要加上 因为不能同一天又买又卖
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }
}
