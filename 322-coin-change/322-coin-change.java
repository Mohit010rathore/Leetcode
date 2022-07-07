class Solution {
    //Memoization
//     public int f(int ind,int T,int[]coins,int [][] dp){
//         if(ind == 0){
//             if(T % coins[0] == 0) return T/ coins[0];
//             return (int)Math.pow(10,9);
//         }
//         if(dp[ind][T] > 0){
//             return dp[ind][T];
//         }
        
//         int notTake = 0 + f(ind-1,T,coins,dp);
//         int take = Integer.MAX_VALUE;
        
//         if(coins[ind] <= T){
//             take = 1+ f(ind, T- coins[ind],coins,dp);
//         }
        
//         return dp[ind][T] =Math.min(take,notTake);
//     }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        for(int T=0;T<= amount;T++){
            if(T % coins[0] == 0) dp[0][T] = T/ coins[0];
            else dp[0][T] = (int)Math.pow(10,9);
        }
        
        for(int ind=1;ind<n;ind++){
            for(int T = 0;T <= amount;T++){
                int notTake = 0 + dp[ind-1][T];
                int take = Integer.MAX_VALUE;
        
                if(coins[ind] <= T){
                    take = 1+ dp[ind][T-coins[ind]];
                }
        
                dp[ind][T] =Math.min(take,notTake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans>= (int)Math.pow(10,9)){
            return -1;
        }
        return ans;
    }
}