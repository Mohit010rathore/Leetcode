class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int leftSmall[]= new int[n];
        int rightSmall[] = new int[n];
        for(int i = 0;i<n;i++){
            while(! s.isEmpty() && heights[i] <= heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                leftSmall[i] = 0;
            }else{
                leftSmall[i] = s.peek() + 1;
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            s.pop();
        }
        
        for(int i = n-1;i>= 0;i--){
            while(! s.isEmpty() && heights[i] <= heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                rightSmall[i] = n-1;
            }else{
                rightSmall[i] = s.peek() - 1;
            }
            s.push(i);
        }
        
        int maxi = 0;
        for(int i =0;i<n;i++){
            maxi= Math.max(maxi,heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxi;
        
    }
}