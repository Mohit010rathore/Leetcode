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
    int []dp=new int[n+1];
    dp[0]=0;
    for(int i=1;i<=n;i++)
    {
        dp[i]=i;
        for(int j=1;j*j<=i;j++)
        {
            int val=j*j;
            dp[i]=Math.min(dp[i],1+dp[i-val]);
        }
    }
    return dp[n];
}
}