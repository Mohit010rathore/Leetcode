class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i =0;i<board.length;i++){
            for(int j = 0;j< board[0].length;j++)
            {
                if(board[i][j] == '.'){
                    
                    //try out every number(char) 1 to 9
                    for(char c ='1';c <= '9';c++){
                        
                        //isValid checks the 3 condns -> the row, the col and the entire 3x3 box
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            
                            //we try out the next empty guy by calling recursion
                            if(solve(board) == true){
                                return true;
                            }else{
                                //if solve(board) return false we backtrack and remove the element
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        //means everything is already filled up-we never got into the if condition
        return true;
    }
    
    boolean isValid(char[][] board,int row,int col,char c){
        for(int i =0;i<9;i++){
            if(board[i][col] == c){
                return false;
            }
            if(board[row][i] == c){
                return false;
            }
            
            if(board[3 * (row/3) + i/3][3 * (col/3) + i % 3] == c){
                return false;
            }
            
        }
        return true;
    }
}