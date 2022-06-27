class Solution {
    public int jump(int[] nums) {
        int n =  nums.length;
        int pos= 0;
        int des = 0;
        int count = 0;
        
        for(int i=0;i<n-1;i++){
            des = Math.max(des,i+nums[i]);
            
            if(pos == i){
                pos = des;
                count++;
            }
        }
        return count;
        
    }
}