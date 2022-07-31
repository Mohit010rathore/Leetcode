class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        
        int[][] ans = new int[m][n];
        
        for (int i = 0; i < m; i++) 
            for (int j = 1; j < n; j++)
                mat[i][j] += mat[i][j - 1];
        
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; j++) 
                mat[i][j] += mat[i - 1][j];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                
                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);
                
                int sum = mat[r2][c2];
                
                sum -= (r1 != 0 ? mat[r1 - 1][c2] : 0);
                sum -= (c1 != 0 ? mat[r2][c1 - 1] : 0);
                sum += (r1 > 0 && c1 > 0 ? mat[r1 - 1][c1 - 1] : 0);
                
                ans[i][j] = sum;
            }
        }
        
        return ans;
    }
}