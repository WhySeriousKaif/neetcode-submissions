class Solution {
    public int maxProfit(int[] prices) {
        int i=1,profit=0,minPrice=prices[0],n=prices.length;
        while(i<n){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            else{
                profit=Math.max(profit,prices[i]-minPrice);
            }
            i++;
        }
        return profit;
        
    }
}
