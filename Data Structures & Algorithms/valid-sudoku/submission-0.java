class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row
        for(int row=0;row<9;row++){
              HashSet<Character> set = new HashSet<>();
            for(int col =0;col<9;col++){
                if(board[row][col]=='.')continue;
                if(set.contains(board[row][col])){
                    return false;
                }
                set.add(board[row][col]);
            }
        }
        //col
            for(int col=0;col<9;col++){
              HashSet<Character> set = new HashSet<>();
            for(int row =0;row<9;row++){
                if(board[row][col]=='.')continue;
                if(set.contains(board[row][col])){
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        for(int row=0;row<9;row+=3){
            int rowend= row+2;
            for(int col=0;col<9;col+=3){
                int colend= col+2;
                if(!validgrid(board,row,rowend,col,colend)){
                    return false;
                }
            }

        }
        return true;
    }
    public boolean validgrid(char [][]board,int row,int rend,int col,int ecol){
          HashSet<Character> set = new HashSet<>();
        for(int i=row;i<=rend;i++){
            for(int j=col;j<=ecol;j++){
                if(board[i][j]=='.')continue;
                    if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);


            }
        }
        return true;
    }
}
