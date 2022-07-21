class Solution {
    public int missingNumber(int[] nums) {
        
        // Using sum of n numbers and actual sum , difference will be the answer
        
        int rSum = (nums.length)*(nums.length + 1)/2;
        int aSum = 0;
        for(int i =0;i<nums.length;i++){
            aSum += nums[i];
        }
        rSum -= aSum;
        return rSum;
        
        
    }
    
   // TLE - //By swapping the numbers for the correct position of elements 
    
     // public int missingNumber(int[] nums){
     //             int n =  nums.length;
     //    for(int i =0;i<n;i++){
     //        int correctPos = nums[i]-1;
     //        while(nums[i] >= 1 && nums[i] <= n && nums[i] != nums[correctPos]){
     //            int temp = nums[correctPos];
     //            nums[correctPos] = nums[i];
     //            nums[i] = temp;
     //        }
     //    }       
     //    for(int i =0;i<n;i++){
     //        if(nums[i] != i+1){
     //            return i+1;
     //        }
     //    }
     //    return n+1;
     // }
}