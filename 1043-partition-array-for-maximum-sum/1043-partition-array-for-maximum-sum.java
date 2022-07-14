class Solution {
    public int f(int ind,int [] arr,int k,int[] dp){
        int n = arr.length;
        if(ind == n) return 0;
        
        if(dp[ind]>0){
            return dp[ind];
        }
        int len =0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        
        for(int j = ind;j < Math.min(n,ind+k);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = len * maxi + f(j+1,arr,k,dp);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[ind] =  maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int [] dp = new int[n];
        
        return f(0,arr,k,dp);
    }
}