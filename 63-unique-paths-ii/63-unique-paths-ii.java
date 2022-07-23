class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        
        return f(m-1,n-1,obstacleGrid,dp);
    }
    
    public int f(int i,int j,int [][]obstacleGrid,int dp[][]){
        if( i >= 0 && j>= 0 && obstacleGrid[i][j] == 1){
            return 0;
        }
        if( i == 0 && j == 0){
            return 1;
        }
        if( i < 0 || j< 0){
            return 0;
        }
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        int up = f(i-1,j,obstacleGrid,dp);
        int left = f(i,j-1,obstacleGrid,dp);
        
        return dp[i][j] = up+left;
    }
}