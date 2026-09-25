class Solution {
    public int swimInWater(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        boolean[][]vis = new boolean[n][m];
        int[][]min= new int[n][m];
        for(int[]g:min){
            Arrays.fill(g,Integer.MAX_VALUE);
        }
       return dfs(0,0,grid,vis,min,grid[0][0]);
    }
    public int dfs(int r, int c ,int[][]grid,boolean[][]vis,int[][]min,int time ){
        int n =grid.length;
        int m = grid[0].length;
        if(r<0|| c<0|| r>=n||c>=m||vis[r][c]){
            return Integer.MAX_VALUE;
        }
        time = Math.max(time, grid[r][c]);
        if(time>=min[r][c]){
            return Integer.MAX_VALUE;
        }
        min[r][c]=time;
        if(r==n-1&&c==m-1){
            return time;
        }
         vis[r][c]=true;
         int le= dfs(r,c-1,grid,vis,min,time);
          int ri= dfs(r,c+1,grid,vis,min,time);
           int up= dfs(r-1,c,grid,vis,min,time);
            int dn= dfs(r+1,c,grid,vis,min,time);
            vis[r][c]=false;
            time =Math.min(Math.min(le,ri),Math.min(up,dn));

            return time;
    }
}
