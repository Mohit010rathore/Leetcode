class Solution {
    class Pair{
        int first;
        int second;
        
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int vis[][] = new int[n][m];
        int count = 0;
        for(int i =0 ;i < n;i++){
            for(int j = 0;j < m;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
    
    public void bfs(int i,int j, char[][] grid, int [][] vis){
        vis[i][j] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i,j));
        int n = grid.length;
        int m = grid[0].length;
        
        while(! q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            for(int delrow = -1;delrow <= 1;delrow++){
                for(int delcol = -1;delcol <= 1;delcol++){
                    
                    if((delrow==-1&&delcol==-1) || (delrow==-1&&delcol==1) || (delrow==1&&delcol==-1) || (delrow==1&&delcol==1)){
                        continue;
                    }
                    
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                        
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
}