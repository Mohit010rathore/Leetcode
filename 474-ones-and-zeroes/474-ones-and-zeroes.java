class Solution {
    //Tabulation
     private static int[] count(String str){
        int ans[] = {0,0};
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '0') ans[0]++;
            else ans[1]++;
        }
        return ans;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        //int dp[][][] = new int[m+1][n+1][strs.length]
        int dp[][][] = new int[strs.length + 1][m + 1][n + 1];
        for(int i = 1;i <= strs.length;i++){
            int cnt[] = count(strs[i - 1]);
            for(int j = 0;j <= m;j++){
                for(int k = 0;k <= n;k++){
                    if(j - cnt[0] >= 0 && k - cnt[1] >= 0){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],1 + dp[i - 1][j - cnt[0]][k - cnt[1]]);
                    }
                    else{
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
    
    //Memoization
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