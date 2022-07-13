class Solution {
    public int[] runningSum(int[] nums) {
        int  n= nums.length;
        
        int[] res = new int[n];
        int prev = 0;
        
        for(int i =0;i<n;i++){
            prev+=nums[i];
            
            res[i] = prev;
        }
        return res;
    } 
}