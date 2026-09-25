class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int n =grid.length;
        int m = grid[0].length;
        int ans=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==1){
                    ans= Math.max(ans,dfs(grid,r,c));
                }
            }
        }
        return ans;
    }
    public static int dfs(int [][]grid,int r,int c){
         int n =grid.length;
        int m = grid[0].length;
        if(r>=n||r<0||c<0||c>=m){
            return 0;
        }
        if(grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;
        return 1+ dfs(grid,r,c-1)+dfs(grid,r,c+1)+dfs(grid,r-1,c)+dfs(grid,r+1,c);
    }
}
