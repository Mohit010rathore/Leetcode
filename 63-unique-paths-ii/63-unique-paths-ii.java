class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        
        return f(n-1,m-1,obstacleGrid,dp);
//         int dp[][]=new int[n][m];
//         for(int i=0; i<n ;i++){
//             for(int j=0; j<m; j++){
          
//               //base conditions
//               if(i>0 && j>0 && obstacleGrid[i][j]==1){
//                   dp[i][j]=0;
//                   continue;
//               }
//               if(i==0 && j==0){
//                  dp[i][j]=1;
//                  continue;
//               }
          
//               int up=0;
//               int left = 0;
          
//               if(i>0) 
//                  up = dp[i-1][j];
//               if(j>0)
//                  left = dp[i][j-1];
            
//               dp[i][j] = up+left;
//             }
//         }
//         return dp[n-1][m-1];
    }
  

    
    public int f(int i,int j,int [][]a,int dp[][]){
       if(i==0&&j==0&&a[i][j]==0)
            return 1;
        else if(i==0&&j==0&&a[i][j]==0)
            return 0;
        else if(i<0 || j<0)
            return 0;
        if(i>=0 && j>=0 && a[i][j] == 1)
            return 0;
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        int up = f(i-1,j,a,dp);
        int left = f(i,j-1,a,dp);
        
        return dp[i][j] = up+left;
    }
}