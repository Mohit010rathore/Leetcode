class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        
        for(String ele : tokens){
            if(isOperator(ele)){
                int el2 = Integer.parseInt(st.pop());
                int el1 = Integer.parseInt(st.pop()); 
                
                int ans = 0;
                if(ele.equals("+")){
                  ans = el1 + el2;
                }else if(ele.equals("*")){
                  ans = el1 * el2;
                }else if(ele.equals("/")){
                  ans = el1/el2;
                }else if(ele.equals("-")){
                  ans = el1 - el2;
                }
                st.push(ans+"");
            }else{
                //operand
                st.push(ele);
            }
            
        }
        return Integer.parseInt(st.peek());
        
    }
    
    private boolean isOperator(String ele){
        if(ele.equals("*") || ele.equals("-") || ele.equals("+") || ele.equals("/")){
            return true;
        }else{
            return false;
        }
    }
}