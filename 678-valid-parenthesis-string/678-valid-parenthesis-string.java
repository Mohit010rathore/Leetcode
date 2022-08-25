class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i=0;i <s.length() ;++i)
        {
            if(s.charAt(i) == '(')
                open.push(i);
            else if(s.charAt(i) == '*')
                star.push(i);
            else
            {
                if(!open.empty()) 
                    open.pop();
                else if(!star.empty())
                    star.pop();
                else
                    return false;
            }
        }
        
        //now process leftover opening brackets
        while(!open.isEmpty()){
            if(star.isEmpty()){
                return false;
                
                //we seeing the index here
            }else if(open.peek() < star.peek()){
                open.pop();
                star.pop();
            }else{
                return false;
            }
        }
        return true;
    }
}