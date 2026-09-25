class Solution {
    List<List<String>> ans= new ArrayList<>();
    
       public List<List<String>> solveNQueens(int n) {
        boolean [][]board = new boolean [n][n];
        queens(board,0);
        return ans ;
    }
    public void queens(boolean[][]board,int row){
        if(row == board.length){
            display(board);
            ans.add(display(board));
            return ;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                queens(board,row+1);
                board[row][col]=false;
                }
        }

    }
    public List<String> display(boolean [][]board){
        List<String>path = new ArrayList<>();
        for(boolean[]row:board){
            StringBuilder s= new StringBuilder();
            for(boolean element:row){
                if(element){
                    s.append("Q");
                }else{
                    s.append(".");
                }
            }
             path.add(s.toString());
            
        }
        return path;
    }
    public boolean isSafe(boolean[][]board, int r , int c){
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }
        int maxleft= Math.min(r,c);
        for(int i=1;i<=maxleft;i++){
            if(board[r-i][c-i])
            {
                return false;
            }
        }
        int maxright=Math.min(r,board.length-1-c);
        for(int i=1;i<=maxright;i++){
            if(board[r-i][c+i]){
                return false;
            }

        }
        return true;
    }
}
