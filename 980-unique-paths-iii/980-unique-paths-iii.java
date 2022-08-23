class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0;
        int sx = 0;
        int sy = 0;
        
        for(int row = 0;row < grid.length;row++){
            for(int col = 0;col < grid[0].length;col++){
                if(grid[row][col] == 0) zero++;
                else if(grid[row][col] == 1){
                    sx = row;
                    sy = col;
                }
            }
        }
        
        return dfs(grid,sx,sy,zero);
    }
    
    public int dfs(int grid[][],int x,int y,int zero){
        
        //base condn
        //robot goes out of boundary 
        
        if(x < 0 || y< 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
           return 0;
        }
        
        if(grid[x][y] == 2){
            return zero == -1 ? 1 : 0;  // why zero = -1, because in above example we have 9 zeroes .So, when we reach the final cell we are covering one cell extra then the zero count.
            // if that's the case we find the path and return '1' otherwise return '0'.
            
        }
        
        grid[x][y] = -1; //mark the visited cell as -1
        zero--;
        
        //calculating all the paths available in 4 directions
        int totalPaths = dfs(grid,x+1,y,zero) + dfs(grid,x-1,y,zero) + dfs(grid,x,y+1,zero) + dfs(grid,x,y-1,zero);
        
        //lets say if we are not able to count all the paths.Now we use backtracking over here
        grid[x][y] = 0;
        zero++;
        
        return totalPaths;
    }
}