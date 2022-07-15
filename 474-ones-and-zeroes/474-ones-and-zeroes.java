class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int a= strs.length;
        int dp[][][] = new int[m+1][n+1][a];
        return f(strs, m, n, 0,dp);
    }
    
    public int f(String[] strs, int m, int n, int i,int dp[][][]){
        if(i==strs.length) return 0;
        
        if(dp[m][n][i] > 0){
            return dp[m][n][i];
        }
        int count1=0;
        for(int j=0; j<strs[i].length(); j++){
            if(strs[i].charAt(j)=='1') count1++;
        }
		int count0 = strs[i].length()-count1;
        
        if(count0<=m && count1<=n){
            return dp[m][n][i]= Math.max( 1 + f(strs, m-count0, n-count1, i+1,dp), f(strs, m, n, i+1,dp)); //we took the max of took and not took
        }
        else return dp[m][n][i] =  f(strs, m, n, i+1,dp); //if the above if condn not satisfies just move and do  nothing
    }
}