class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList();
        
        //we will write the recursive function
        findAll("(",1,0,n,ans);  // we will start with open bracket, and maintain count of open bracket as of bow we put 1..as we started with open and closeCount =0 and pass n bcoz we have to know how many open and close bracket we should use and pass the ans
        return ans;
    }
    
    public void findAll(String current, int openCount,int closeCount,int n,List<String> ans){
        
        if(current.length() == 2 * n){
            ans.add(current);
            return;
        }
        
        //condition 1 - how many open bracket should be added
        if(openCount < n){
            findAll(current + '(',openCount + 1,closeCount,n,ans);
        }
        //condition 2 - how many close bracket should be added
        if(closeCount < openCount){
            findAll(current + ')',openCount,closeCount + 1,n,ans);
        }
    }
}