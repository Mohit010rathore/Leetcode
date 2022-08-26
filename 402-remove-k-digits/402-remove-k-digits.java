class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        for(;i<num.length() && k>0;){
            while(k>0 && !st.isEmpty() && num.charAt(i) < st.peek()){
                st.pop();
                
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        
        while(!st.isEmpty() && k> 0){
            st.pop();
            k--;
        }
        
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        
        ans  = ans + num.substring(i,num.length());
        
        //removing leading zeroes
        i=0;
        while(i < ans.length()){
            if(ans.charAt(i) == '0'){
                i++;
            }else{
                break;
            }
        }
        
        return ans.substring(i).length() ==0 ? "0":ans.substring(i);
    }
}