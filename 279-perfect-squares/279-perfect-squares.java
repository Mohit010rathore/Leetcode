class Solution {
    public int f(int n,int dp[]){
        if(n <= 3){
            return n;
        }
        if(dp[n] > 0){
            return dp[n];
        }
        
        int ans = n;
        for(int i=1;i*i<=n;++i){
            ans=  Math.min(ans,1 + f(n-i*i,dp));
        }
        return dp[n] = ans;
    }
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        return f(n,dp);
    }
}