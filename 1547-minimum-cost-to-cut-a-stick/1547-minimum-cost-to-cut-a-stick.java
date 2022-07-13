class Solution {
//     public int f(int i,int j,int[] nCuts,int[][] dp){
//         if(i>j){
//             return 0;
//         }
//         if(dp[i][j] > 0){
//             return dp[i][j];
//         }
//         int mini = Integer.MAX_VALUE;
//         for(int ind = i;ind<=j;ind++){
//             int cost = nCuts[j+1]-nCuts[i-1] + f(i,ind-1,nCuts,dp) + f(ind+1,j,nCuts,dp);
            
//             mini= Math.min(mini,cost);
//         }
//         return dp[i][j]  =  mini;
    // }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] nCuts = new int[c + 2];
        nCuts[0] = 0;
        nCuts[c + 1] = n;
        System.arraycopy(cuts, 0, nCuts, 1, c);
        Arrays.sort(nCuts);
        
        // int dp[][] = new int[c+1][c+1];
        
        int dp[][] = new int[c+2][c+2];
        
        // return f(1,c,nCuts,dp);
        for(int i =c;i>= 1;i--){
            for(int j = 1;j<= c;j++){
                if(i > j) continue;
                
                int mini = Integer.MAX_VALUE;
                for(int ind = i;ind<=j;ind++){
                    int cost = nCuts[j+1]-nCuts[i-1] + dp[i][ind-1] + dp[ind+1][j];
            
                    mini= Math.min(mini,cost);
                }
                dp[i][j]  =  mini;
            }
        }
        return dp[1][c];
    }
}