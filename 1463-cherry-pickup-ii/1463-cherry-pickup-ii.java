class Solution {
    public int f(int i,int j1,int j2,int r,int c,int[][] grid,int [][][] dp){
        if(j1<0 || j2<0 || j1>=c || j2 >= c){
            return (int)(Math.pow(-10, 9));
        }
        
        if( i == r-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] > 0){
            return dp[i][j1][j2];
        }
        
        //explore all paths of alice and bob simultaneously
        int maxi = Integer.MIN_VALUE;
        for(int dj1 = -1;dj1<= +1 ; dj1++){
            for(int dj2 = -1;dj2 <= +1 ; dj2++){
               int value =0;
                if(j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                
                value += f(i+1,j1+dj1, j2+dj2,r,c,grid,dp);
                maxi = Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2] =  maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
         int [][][] dp = new int[n][m][m];        
        
//         for(int j1 =0 ;j1<m;j1++){
//             for(int j2 = 0;j2<m;j2++){
//                 if(j1==j2) dp[n-1][j1][j2] = grid[n-1][j1];
//                 else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
//             }
//         }
        
//         for(int i= n-2;i>=0;i--){
//             for(int j1 = 0;j1<m;j1++){
//                 for(int j2 =0 ;j2<m;j2++){
                    
//                       int maxi = Integer.MIN_VALUE;
//                       for(int dj1 = -1;dj1<= 1 ; dj1++){
//                           for(int dj2 = -1;dj2 <= 1 ; dj2++){
//                                int value =0;
//                                if(j1 == j2) value = grid[i][j1];
//                                else value = grid[i][j1] + grid[i][j2];
                               
//                               if((j1+dj1 < 0 || j1+dj1 >= m) || (j2+ dj2 < 0 || j2+dj2 >= m)){
//                                   value += (int)(Math.pow(-10, 9));
//                               }else{
//                                   value += dp[i+1][j1+dj1][j2+dj2];
//                               }
                               
//                               maxi = Math.max(maxi,value);
//                           }
//                       }
//                       return dp[i][j1][j2] =  maxi;
                    
//                 }
//             }
//         }
//         return dp[0][0][m-1];
        for (int j1 = 0; j1 < m; j1++) {
           for (int j2 = 0; j2 < m; j2++) {
              if (j1 == j2)
                 dp[n - 1][j1][j2] = grid[n - 1][j1];
              else
                 dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
           }
        }

    //Outer Nested Loops for travering DP Array
    for (int i = n - 2; i >= 0; i--) {
      for (int j1 = 0; j1 < m; j1++) {
        for (int j2 = 0; j2 < m; j2++) {

          int maxi = Integer.MIN_VALUE;

          //Inner nested loops to try out 9 options
          for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

              int ans;

              if (j1 == j2)
                ans = grid[i][j1];
              else
                ans = grid[i][j1] + grid[i][j2];

              if ((j1 + di < 0 || j1 + di >= m) ||
                (j2 + dj < 0 || j2 + dj >= m))

                ans += (int) Math.pow(-10, 9);
              else
                ans += dp[i + 1][j1 + di][j2 + dj];

              maxi = Math.max(ans, maxi);
            }
          }
          dp[i][j1][j2] = maxi;
        }
      }
    }

    return dp[0][0][m - 1];
        
        
    }
}