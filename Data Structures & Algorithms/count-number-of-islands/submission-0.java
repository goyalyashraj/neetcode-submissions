class Solution {
    int count=0;
    public int numIslands(char[][] grid) {
        for(int r=0;r<grid.length;r++){
          for(int c=0;c<grid[0].length;c++)  {
            if(grid [r][c]=='1'){
                count++;
                dfs(grid,r,c);
            }
          }
        }
        return count;  
    }
    public static void dfs(char[][]grid , int row , int col){
        int n =grid.length;
        int m = grid[0].length;
        if(row>=n || row<0 || col>=m || col<0){
            return ;
        }
        if(grid[row][col]=='0'){
            return ;
        }
        grid[row][col]='0';
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);

    }
}
