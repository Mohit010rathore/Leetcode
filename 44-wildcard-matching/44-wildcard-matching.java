class Solution {
    public boolean isMatch(String s, String p)
    {
        int n = s.length();
        int m = p.length();
        
       Boolean dp[][] = new Boolean[n+1][m+1];
         return help(n,m,s,p,dp);
    }
    public boolean help(int n,int m,String s,String p,Boolean dp[][])
    {
        if(n==0 && m==0) return true;
        if(n==0) {
            for(int i=0;i<m;i++) {
                if(p.charAt(i)!='*') return false;
            }
            return true;
        }
        if(n==0 || m==0) return false;
        
        if(dp[n][m] != null) return dp[n][m];
        
        if(p.charAt(m-1)==s.charAt(n-1))return dp[n][m] = help(n-1,m-1,s,p,dp);
        
        else if(p.charAt(m-1)=='?') return dp[n][m] = help(n-1,m-1,s,p,dp);
        
        else if(p.charAt(m-1)=='*'){
            return dp[n][m] = help(n-1,m,s,p,dp) || 
                help(n-1,m-1,s,p,dp) || help(n,m-1,s,p,dp);
        }
        else return dp[n][m] = false;
    }
}