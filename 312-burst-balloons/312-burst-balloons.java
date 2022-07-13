class Solution {
    public int f(int i ,int j,int a[],int dp[][]){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        
        if(dp[i][j] > 0){
            return dp[i][j] ;
        }
        for(int ind =i;ind <= j;ind++){
            int cost = a[i-1] * a[ind] * a[j+1] + f(i,ind-1,a,dp) + f(ind+1,j,a,dp);
            maxi= Math.max(cost,maxi);
            
        }
        return dp[i][j] =  maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nCuts = new int[n + 2];         // creating a new array of size n+2
        nCuts[0] = 1;                         // inserting 1 at the front  
        nCuts[n + 1] = 1;                     //inserting 1 at the back
        System.arraycopy(nums, 0, nCuts, 1, n);
        
        int dp[][] = new int[n+1][n+1];
        return f(1,n,nCuts,dp);
    }
}