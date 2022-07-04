class Solution {
    public int f(int i,int j,int[][] matrix,int[][] dp){
        if(j<0 || j>= matrix[0].length){
            // return (int)Math.pow(-10,9); 
            return -100000000;
        }
        if(i==0){
            return matrix[0][j];
        }
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        int u = matrix[i][j] + f(i-1,j,matrix,dp);
        int ld =  matrix[i][j] + f(i-1,j-1,matrix,dp);
        int rd =  matrix[i][j] + f(i-1,j+1,matrix,dp);
        
        return dp[i][j] = Math.min(u,Math.max(ld,rd));
    }
    
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
        
//         int [][] dp = new int [n][m];
        
//         for(int j =0 ;j<m;j++) dp[0][j] = matrix[0][j];
//         for(int i = 1;i<n;i++){
//             for(int j = 0;j<m;j++){
//                 int u = matrix[i][j] + dp[i-1][j];
//                 int ld =  matrix[i][j] ;
//                 if(j-1>0){
//                     ld += dp[i-1][j-1];
//                 }else{
//                     ld+= Integer.MAX_VALUE;
//                 }
//                 int rd =  matrix[i][j];
//                 if(j+1<m){
//                     rd += dp[i-1][j+1];
//                 }else{
//                     rd += Integer.MAX_VALUE;
//                 }
                
//                 dp[i][j] = Math.min(u,Math.min(ld,rd));
//             }
//         }
        
//         int mini = Integer.MAX_VALUE;
//         for(int j = 0;j<m;j++){
//             mini = Math.min(mini,dp[n-1][j]);
//         }
//         return mini;
//     }
        public int minFallingPathSum(int[][] A) {
        int len = A.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[0][i] = A[0][i];
        }
        for(int i = 1; i < len; i++){
            for(int j = 0; j < len; j++){
                dp[i][j] = Math.min(Math.min(j > 0 ? dp[i - 1][j -                  1]: Integer.MAX_VALUE, j + 1 < len ? dp[i - 1][j +                  1]: Integer.MAX_VALUE), dp[i - 1][j]) + A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++)
            res = Math.min(res, dp[len - 1][i]);
        return res;
    }
}
