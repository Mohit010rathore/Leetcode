class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countPartitions(n,target,nums);
        
        
    }
    public static int countPartitions(int n,int d,int []nums){
        int totSum = 0;
        for(int i=0;i<n;i++){
            totSum += nums[i];
        }
        
        if(totSum-d <0 || (totSum-d)%2==1 ) return 0;
        return findWays(nums,(totSum-d)/2);
    }
    public static int findWays(int[] num , int tar){
        int n = num.length;

    int prev[]=new int[tar+1];
    
    if(num[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
    else prev[0] = 1;  // 1 case - not pick
    
    if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;  // 1 case -pick
    
    for(int ind = 1; ind<n; ind++){
        int cur[]=new int[tar+1];
        for(int target= 0; target<=tar; target++){
            int notTaken = prev[target];
    
            int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];
        
            cur[target]= (notTaken + taken);
        }
        prev = cur;
    }
    return prev[tar];
    }
}