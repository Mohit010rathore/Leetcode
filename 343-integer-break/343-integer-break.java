class Solution {
    public int f(int n,int dp[]){
        if(n < 2) return 0;
        
        if(dp[n] > 0){
            return dp[n];
        }
        
        int maxP = 1;
        
        for(int i =1;i<n;i++){
            //here we check if the the product we get from breaking the integer is greter or less than by not breaking it.
            int currP = Math.max(f(n-i,dp),n-i); //max(breaking further product , not breaking and checking)
            
            //take the maximum of current product * i and the maxProduct
            maxP = Math.max(currP * i,maxP );
        }
        return dp[n] = maxP;
    }
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        return f(n,dp);
    }
}