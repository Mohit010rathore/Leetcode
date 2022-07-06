class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum =0 ;
        for(int i=0;i<n;i++) totSum += nums[i];
        
        if(totSum % 2 == 1) return false;
        int target = totSum/2;
        
        return subsetSumTok(n,target,nums);
           
        
    }
    
    public boolean subsetSumTok(int n,int k,int[] nums){
        boolean [] prev = new boolean[k+1];
        
        prev[0] = true;
        if(nums[0] <= k){
            prev[nums[0]] = true;
        }
        for(int ind = 1;ind<n;ind++){
            boolean [] cur = new boolean[k+1];
            cur[0] = true;
            for(int target = 1;target<=k;target++){
                boolean notTake = prev[target];
                boolean take = false;
                
                if(nums[ind]<= target) take = prev[target-nums[ind]];
                cur[target] = take || notTake;
            }
            prev = cur;
        }
        return prev[k];
    }
}