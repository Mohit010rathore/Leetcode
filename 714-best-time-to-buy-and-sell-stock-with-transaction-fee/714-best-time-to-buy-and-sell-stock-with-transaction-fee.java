class Solution {
    public int maxProfit(int[] prices, int fee) {
        int  n = prices.length;
        int dp[][] = new int [n+1][2];
        dp[n][0] = dp[n][1] = 0;
        
        for(int ind =n-1;ind>=0;ind--){
            for(int buy= 0;buy<= 1;buy++){
                int profit = 0;
                
                //we can buy the stock
                if(buy==0){
                     profit =  Math.max(-prices[ind] + dp[ind+1][1], 0 +dp[ind+1][0]);
                }
               //we can sell the stock
               if(buy == 1){
                     profit =  Math.max(prices[ind]- fee + dp[ind+1][0], 0 + dp[ind+1][1]);
               }
                
                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }
}