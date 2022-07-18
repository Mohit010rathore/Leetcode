class Solution {
    public String simplifyPath(String path) {
        Stack st = new Stack<>();
        String[] pathList = path.split("\\/");  //this is the way of writing since we need to escape the backslash- we store the modified string in this pathlist
        
        for(String p: pathList){
            if(p.length() == 0 || p.equals(".")){  //do nothing
                continue;
            }else if(p.equals("..")){  //move to upper directory - popping from the stack
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{   //if its a string character we push into the stack
                //String case
                st.push(p);
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + "/" + ans;  //whatever we are popping adding it in the front of the ans with one backslash
        }
        
        if(ans.length() == 0){  //corner case id the ans string comes out to be empty we return backslash
            return "/";
        }else{
            return "/" + ans.substring(0,ans.length()-1); //we just removing the last backslash and letting it in front
        }
    }
}