/**
 * created by Zheng Jiateng on 2019/5/27.
 */

/**
 * 121. Best Time to Buy and Sell Stock
 *
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
