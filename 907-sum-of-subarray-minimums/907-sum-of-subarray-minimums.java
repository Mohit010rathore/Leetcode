class Solution{
    private final long MOD = 1_000_000_007;
    
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<Integer>();
        int[] leftDist = new int[arr.length];
        int[] rightDist = new int[arr.length];
        long sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]) st.pop();
            
			leftDist[i] = st.isEmpty() ? i+1 : i-st.peek();
            st.push(i);
        }
        st.clear();
        
        for(int i = arr.length-1; i >= 0; i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) st.pop();            
            
			rightDist[i] = st.isEmpty() ? arr.length-i : st.peek()-i;
            st.push(i);
        }
        
        for(int i = 0; i < arr.length; i++) 
			sum = (sum + (long)arr[i]*leftDist[i]*rightDist[i]) % MOD;
        
        return (int)sum;
    }
}