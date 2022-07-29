class Solution {
    //MEMOIZATION
    
//     public int f(int ind,int prev_ind,int [] arr,int n, int dp[][]){
//         if(ind == n) return 0;
        
//         if(dp[ind][prev_ind+1] > 0){
//             return dp[ind][prev_ind+1];
//         }
//         int len = 0 + f(ind+1,prev_ind,arr,n,dp);
        
//         if(prev_ind == -1 || arr[ind] > arr[prev_ind]){
//             len = Math.max(len ,1 + f(ind+1,ind,arr,n,dp));
//         }
//         return dp[ind][prev_ind+1]= len;
//     }
    
    
    //TABULATED
    
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int dp[][] = new int[n+1][n+1];
//         //return f(0,-1,nums,n,dp);
        
//         for(int ind = n-1;ind>=0;ind--){
//             for(int prev_ind = ind-1;prev_ind >=-1;prev_ind-- ){
//                 int len = 0 + dp[ind+1][prev_ind+1];
        
//                 if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
//                     len = Math.max(len ,1 + dp[ind+1][ind+1]);
//                 }
//                 dp[ind][prev_ind+1]= len;
//             }
//         }
//         return dp[0][-1+1];
//     }
    
    
    //SPACE OPTIMISED
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int cur [] = new int [n+1];
        int next [] = new int[n+1];
         //return f(0,-1,nums,n,dp);
        
        for(int ind = n-1;ind>=0;ind--){
            for(int prev_ind = ind-1;prev_ind >=-1;prev_ind-- ){
                int len = 0 + next[prev_ind+1];
        
                if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
                    len = Math.max(len ,1 + next[ind+1]);
                }
                cur[prev_ind+1]= len;
            }
            next = cur;
        }
        return next[-1+1];
    }
    
    
}