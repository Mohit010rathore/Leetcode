class Solution {
    public int f(int ind,int T,int[]coins,int[][] dp){
        if(ind ==0 ){
            if(T%coins[0]==0)
              return 1;
            else
              return 0;
        }
        if(dp[ind][T] >0){
            return dp[ind][T];
        }
        
        int notTake = f(ind-1, T, coins,dp);
        int take =0;
        if(coins[ind] <= T ) take = f(ind,T- coins[ind],coins,dp);
        return take + notTake;
    }
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        
        for(int i = 0;i <= amount;i++){
            if(i % coins[0] == 0){
                dp[0][i] = 1;
            }
        }
        
        for(int ind = 1;ind< n;ind++){
            for(int target = 0;target <= amount;target++){
                int notTake = dp[ind-1][target];
                int take =0;
                if(coins[ind] <= target ) take = dp[ind][target-coins[ind]];
                dp[ind][target] =  take + notTake;
            }
        }
        return dp[n-1][amount];
    }
}