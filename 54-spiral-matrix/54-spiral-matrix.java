class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top,down,left,right,dir;
        top = 0;
        down = matrix.length-1;
        left = 0;
        right = matrix[0].length-1;
        
        dir = 0;
        
        List<Integer> res = new ArrayList<>();
        
        while(top <= down && left <= right){
            if(dir == 0){
                for(int i = left;i<= right;i++){
                    res.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top;i<= down;i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right;i >= left;i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }
            else if(dir == 3){
                for(int i = down;i >= top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1) %4;
        }
        return res;
        
    }
}