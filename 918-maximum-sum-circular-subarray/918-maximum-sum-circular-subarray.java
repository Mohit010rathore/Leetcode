class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n =nums.length;
        int max_normal = normalMaxSum(nums);
        
        if(max_normal<0){
            return max_normal;
        }
        
        int arr_sum = 0;
        for(int i=0;i<n;i++){
            arr_sum += nums[i];
            nums[i] = -nums[i];
        }
        
        int max_circular = arr_sum + normalMaxSum(nums);
        return Math.max(max_normal,max_circular);
    }
    
    public int normalMaxSum(int nums[] ){
        int n = nums.length;
        int res = nums[0];
        int maxEnding = nums[0];
        
        for(int i=1;i<n;i++){
            maxEnding = Math.max(nums[i],maxEnding+nums[i]);
            res =Math.max(res,maxEnding);
        }
        return res;
    }
}