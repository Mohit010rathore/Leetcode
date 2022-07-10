class Solution {
//     public int f(int ind,int buy,int[] prices,int n,int[][] dp){
//         if(ind == n){
//             return 0;
//         }
//         if(dp[ind][buy] > 0){
//             return dp[ind][buy];
//         }
        
//         int profit = 0;
//         //We can buy the stock
//         if(buy==0){
//             profit =  Math.max(-prices[ind] + f(ind+1,1,prices,n,dp), 0 + f(ind+1,0,prices,n,dp));
//         }
//         //we can sell the stock
//         if(buy==1){
//             profit =  Math.max(prices[ind] + f(ind+1,0,prices,n,dp), 0 + f(ind+1,1,prices,n,dp));
//         }
//         return profit;
//     }
    public int maxProfit(int[] prices) {
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
                     profit =  Math.max(prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
               }
                
                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
        
    }
}