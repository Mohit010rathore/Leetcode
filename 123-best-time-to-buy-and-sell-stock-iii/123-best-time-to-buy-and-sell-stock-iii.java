class Solution {
    public int f(int ind,int buy,int cap,int [] prices,int n,int [][][] dp){
        if(cap ==0 || ind == n){
            return 0;
        }
        if(dp[ind][buy][cap] > 0){
            return dp[ind][buy][cap];
        }
        if(buy == 1){
            return dp[ind][buy][cap] = Math.max(-prices[ind] + f(ind+1,0,cap,prices,n,dp), 0 + f(ind+1,1,cap,prices,n,dp));
        }
        return dp[ind][buy][cap] = Math.max(prices[ind] + f(ind+1,1,cap-1,prices,n,dp), 0 + f(ind+1,0,cap,prices,n,dp));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int [n+1][2][3];

        //return f(0,1,2,prices,n,dp);   
        for(int ind = n-1;ind >= 0;ind--){
            for(int buy = 0;buy<= 1;buy++){
                for(int cap = 1;cap<= 2;cap++){
                    
                    if(buy == 1){
                          dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind+1][0][cap], 0 + dp[ind+1][1][cap]);
                    }else{
                          dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind+1][1][cap-1], 0 + 
                                                      dp[ind+1][0][cap]);    
                    }
                    
                }
            }
        }
        return dp[0][1][2];
    }
}