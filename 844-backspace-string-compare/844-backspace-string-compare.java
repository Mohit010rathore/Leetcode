class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack <Character> st1 = new Stack<>();
        Stack <Character> st2 = new Stack<>();
        
        for(char i =0 ;i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(!st1.isEmpty()){
                   st1.pop();   
                }
            }else{
                st1.push(s.charAt(i));
            }
        }
        
        for(char i =0 ;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(!st2.isEmpty()){
                   st2.pop();   
                }
            }else{
                st2.push(t.charAt(i));
            }
        }
        
        if(st1.size() != st2.size()){
            return false;
        }else{
            while(!st1.isEmpty() && !st2.isEmpty()){
                char c1 = st1.pop();
                char c2 = st2.pop();
                
                if(c1 != c2){
                    return false;
                }
            }
            return true;
        }
    }
}