class Solution {
    public int f(int ind,int T,int[]coins,int [][] dp){
        if(ind == 0){
            if(T % coins[0] == 0) return T/ coins[0];
            return (int)Math.pow(10,9);
        }
        if(dp[ind][T] > 0){
            return dp[ind][T];
        }
        
        int notTake = 0 + f(ind-1,T,coins,dp);
        int take = Integer.MAX_VALUE;
        
        if(coins[ind] <= T){
            take = 1+ f(ind, T- coins[ind],coins,dp);
        }
        
        return dp[ind][T] =Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        int ans =  f(n-1, amount,coins,dp);
        if(ans >= (int)Math.pow(10,9)) return -1;
        
        return ans;
    }
}