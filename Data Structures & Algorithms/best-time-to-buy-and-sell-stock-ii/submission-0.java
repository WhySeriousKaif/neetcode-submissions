
class Solution {
    public int maxProfit(int[] prices) {

        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            int profit = prices[i]-prices[i-1];

            if (prices[i]>prices[i-1]) {
                totalProfit += profit;
            }
        }

        return totalProfit;
    }
}
