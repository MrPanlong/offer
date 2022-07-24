package offer1;

/**
 * @ClassName: MaxProfit
 * @Date: 2022/7/24 17:37
 * @Author: panLong
 * @Description: TODO
 */

public class MaxProfit {
    public int maxProfit(int[] prices){
        int cost = Integer.MAX_VALUE,profit = 0;
        for (int price : prices) {
            cost = Math.min(cost,price);
            profit = Math.max(profit,price - cost);
        }
        return profit;
    }
}
