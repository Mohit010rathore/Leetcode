class Solution {
 public int maximalRectangle(char[][] matrix) {
    int max=Integer.MIN_VALUE;
    int[] ary=new int[matrix[0].length];

	for(int i=0;i<matrix.length;i++)
	{
		for(int j=0;j<matrix[0].length;j++)
		{
			if(matrix[i][j]=='1')
			{
				ary[j]=ary[j]+1;
			}
            else if(matrix[i][j]=='0')
				ary[j]=0;
		}
		max=Math.max(max,largestRectangle(ary));
	}
	return max;
 }
    
    //for measuring the area of height array ,which we get after per row
  public int largestRectangle(int[] heights){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++){
           while(!st.empty() && (i==heights.length || heights[st.peek()] >=                         heights[i])) {
               int height = heights[st.peek()];
               st.pop();
               int width;
               if(st.empty()) 
                   width = i;
               else
                   width = i - st.peek() - 1;
               maxArea = Math.max(maxArea,width*height);
           } 
            st.push(i);
        }
        return maxArea;
    }
}