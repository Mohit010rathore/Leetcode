class NumMatrix {
    int[][] matrix;
    int[][] sumMatrix;
    int n, m = 0;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.sumMatrix = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                this.sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] 
                    - sumMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row2+1][col2+1] - sumMatrix[row1][col2+1]
            - sumMatrix[row2+1][col1] + sumMatrix[row1][col1];
        return sum;
    }
}