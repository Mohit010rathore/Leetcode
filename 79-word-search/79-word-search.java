class Solution {
    public boolean search(int i ,int j, int n,int m,char[][] board, String word ,int k){
        //k is the index od word on which we are currently pointing to
        if(k == word.length()) return true;
        //checking we are not crossing the boundary and if the current character
        //we are standing at, is not the required character
        if(i < 0 || j < 0 || i == n || j == m || board[i][j] != word.charAt(k)){
            return false;
        }
        
        char ch = board[i][j];
        board[i][j] = '#';
        
        boolean op1 = search(i+1,j,n,m,board,word,k+1);
        boolean op2 = search(i,j+1,n,m,board,word,k+1);
        boolean op3 = search(i-1,j,n,m,board,word,k+1);
        boolean op4 = search(i,j-1,n,m,board,word,k+1);
        
        board[i][j] = ch;
        
        return op1 || op2 || op3 || op4;
    }
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j< m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(i,j,n,m,board,word,0)) return true;
                }
            }
        }
        return false;
    }
}