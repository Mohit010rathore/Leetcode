class Solution {
    public boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public int f(int i,int n,String s,int dp[]){
        if(i== n)return 0 ;
        
        if(dp[i]>0){
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        
        //i.....j
        for(int j =i;j<n;j++){
            if(isPalindrome(i,j,s)){
                int cost = 1 + f(j+1,n,s,dp);
                
                minCost = Math.min(cost,minCost);
            }
        }
        return dp[i] = minCost;
    }
    public int minCut(String s) {
        int n = s.length();
        //int dp[] = new int [n];
        //return f(0,n,s,dp) - 1;
        
        int dp[] = new int [n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int minCost = Integer.MAX_VALUE;
        
            for(int j =i;j<n;j++){
                 if(isPalindrome(i,j,s)){
                     int cost = 1 + dp[j+1];
                
                     minCost = Math.min(cost,minCost);
                 }
            }
            dp[i] = minCost;
        }
        return dp[0]-1;
    }
}