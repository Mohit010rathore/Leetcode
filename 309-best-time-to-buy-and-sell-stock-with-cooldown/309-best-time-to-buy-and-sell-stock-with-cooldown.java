class Solution {
//     public int f(int ind,int buy,int [] prices,int n,int dp[][]){
        
//         if(ind >= n) return 0;
        
//         if(dp[ind][buy] >0){
//             return dp[ind][buy];
//         }
//         if(buy == 1){
//             return Math.max(-prices[ind] + f(ind + 1,0,prices,n,dp), 0 + f(ind+1,1,prices,n,dp));
//         }
//         return Math.max(prices[ind] + f(ind+2,1,prices,n,dp) , 0 + f(ind+1,0,prices,n,dp));
//     }
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int dp[][] = new int[n+2][2];
        //return f(0,1,prices,n,dp);
        
        //we will not write base case
        for(int ind = n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                
                if(buy == 1){
                   dp[ind][buy] = Math.max(-prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
                }else{
                    dp[ind][buy] =  Math.max(prices[ind] +dp[ind+2][1], 0 + dp[ind+1][0]);
                }
                
            }
        }
        return dp[0][1];
        
    }
}