class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length; 
         
        //k can be greater that the length of the array
        //so we normalize it
        k=k%n;
        
        //first we reverse the whole array
        reverse(nums,0,n-1);
        
        //secondly we reverse the first k elements of the reversed arrray
        reverse(nums,0,k-1);
        
        //and at last we reverse the left over elements after the kth elements
        reverse(nums,k,n-1);
            
         
    }
    
    private void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}