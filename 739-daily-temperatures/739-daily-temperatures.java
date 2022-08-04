class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack();
        int n = temperatures.length;
        int [] res = new int[n];
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                //found an increasing value for st.peek() index
                res[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return res;
        
        
    }
}