class Solution {
//    public int rob(int[] nums){
//         int n = nums.length;
//         int prev = nums[0];
//         int prev2 = 0;
        
//         for(int i=0;i<n;i++){
//             int take = nums[i];
//             if(i>1) take += prev2;
            
//             int notTake =0 + prev;
            
//             int curi = Math.max(take,notTake);
//             prev2 = prev;
//             prev = curi;
//         }
//         return prev;
        
//     } 
    
    public int rob(int[] nums){
        int  n = nums.length;
        int prev2 = 0;
        int prev = nums[0];
        
        for(int i =0;i < n;i++){
            int take = nums[i];
            if(i > 1){
              take += prev2;   
            }
            int notTake  = 0 + prev;
               
            int curi = Math.max(take,notTake);
            
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}