class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        
        char prevSign = '+';
        int curr_no = 0;
        
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){  //if the current character is a digit
                curr_no = curr_no * 10 + (c -'0');  //this is a standard way to calcualte the number
            }
            
            //if the current character is a operand
            
            if(isOperator(c) || i== s.length()-1){
                if(prevSign  == '+'){
                    st.push(curr_no);
                }else if(prevSign == '-'){
                    st.push(-curr_no);
                } else if(prevSign == '*'){
                    int top = st.pop();
                    
                    st.push(top * curr_no);
                }else if(prevSign == '/'){
                    int top = st.pop();
                    
                    st.push(top / curr_no);
                }
                
                curr_no= 0;
                prevSign = c;
            }
        }
        
        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
    
    private boolean isOperator(char c){
        return c =='+' || c =='-' || c=='/' || c=='*';
    }
}