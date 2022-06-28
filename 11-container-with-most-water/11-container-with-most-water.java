class Solution {
    public int maxArea(int[] height) {
        int low =0;
        int high = height.length-1;
        
        int max = 0;
        
        while(low<high){
            int lh = height[low];
            int rh = height[high];
            
            int min_height = Math.min(lh,rh);
            int curr_max = min_height * (high-low);
            
            max = Math.max(max,curr_max);
            if(lh < rh){
                low++;
            }
            else{
                high--;
            }
        }
        return max;
        
    }
}