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
		max=Math.max(max,check(ary));
	}
	return max;
 }
  private int check(int[] nums) {
	Stack<Integer> hs=new Stack<>();
	int[] left=new int[nums.length];
	
    for(int i=0;i<nums.length;i++)
    {
    	while(!hs.empty() && nums[hs.peek()]>=nums[i])
    		hs.pop();
    	if(hs.empty())left[i]=0;
    	else left[i]=hs.peek()+1;
    	hs.push(i);
    		
    }
  
    while(!hs.empty())hs.pop();
    int[] right=new int[nums.length];
	
    for(int i=nums.length-1;i>=0;i--)
    {
    	while(!hs.empty() && nums[hs.peek()]>=nums[i])
    		hs.pop();
    	if(hs.empty())right[i]=nums.length-1;
    	else right[i]=hs.peek()-1;
    	hs.push(i);
    		
    } 
    int max=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++)
    {
     max=Math.max(max,(right[i]-left[i]+1)*nums[i]);
    }
	return max;
  }
}