class Solution {
    
    //Memoized
    
//     public int f(int []nums,int target,int[]dp){
//         if(target < 0)return 0;
//         if(target == 0) return 1;
        
//         if(dp[target] > 0){
//             return dp[target];
//         }
        
//         int res = 0;
//         for(int i =0;i<nums.length;i++){
//             res += f(nums,target-nums[i],dp);
//         }
//         return dp[target]= res;
//     }
    public int combinationSum4(int[] nums, int target) {
        // int dp[] = new int[target+1];
        // return f(nums,target,dp);
        
        int dp[] = new int [target+1];
        
        dp[0] = 1;
        
        //traversing from target 1 to target
        for(int i =1;i<= target;i++){
            
            //traversing the num array
            for(int j=0;j<nums.length;j++){
                if(i-nums[j] >= 0){
                     dp[i] += dp[i-nums[j]];
                }
               
            }
        }
        return dp[target];
    }
}