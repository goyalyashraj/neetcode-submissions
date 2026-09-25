class Solution {List<String> ans= new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0;i<words.length;i++){
            if(exist(board,words[i])){
                ans.add(words[i]);
            }
        }
        return ans;
    }
    public boolean exist(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(board[r][c]==word.charAt(0)){
                    boolean found= dfs(board,word,0,r,c);
                    if(found){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][]board,String word,int index,int r, int c){
        if(index==word.length()){
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        if(r<0||r>=n||c<0||c>=m){
            return false;
        }
        if(board[r][c]==' '||board[r][c]!=word.charAt(index)){
            return false;
        }
        char ch = board[r][c];
        board[r][c]=' ';
        boolean ok= dfs(board,word,index+1,r,c-1)||
       dfs(board,word,index+1,r,c+1)||
        dfs(board,word,index+1,r-1,c)||
        dfs(board,word,index+1,r+1,c);
        board[r][c]=ch;
        return ok;


    }
}
