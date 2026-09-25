class Solution {
    class Pair{
        int r;
        int c;
        int t;
        public Pair(int r, int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair>q= new LinkedList<>();
      int n = grid.length;
      int m= grid[0].length;
      for(int r=0;r<n;r++){
        for(int c=0;c<m;c++){
            if(grid[r][c]==0){
                q.offer(new Pair(r,c,0));
        }
        }
      } 
      bfs(grid,q);
    }
    public void bfs(int[][] grid,Queue<Pair>q){
        int n = grid.length;
      int m= grid[0].length;
      while(!q.isEmpty()){
        Pair p = q.poll();
        int row=p.r;
        int col= p.c;
        int dis= p.t;
        if(row-1>=0 && grid[row-1][col]==Integer.MAX_VALUE){
            grid[row-1][col]=dis+1;
            q.offer(new Pair(row-1,col,dis+1));
        }
        if(col-1>=0 && grid[row][col-1]==Integer.MAX_VALUE){
            grid[row][col-1]=dis+1;
            q.offer(new Pair(row,col-1,dis+1));
        }
        if(row+1<n && grid[row+1][col]==Integer.MAX_VALUE){
            grid[row+1][col]=dis+1;
            q.offer(new Pair(row+1,col,dis+1));
        }
        if(col+1<m && grid[row][col+1]==Integer.MAX_VALUE){
            grid[row][col+1]=dis+1;
            q.offer(new Pair(row,col+1,dis+1));
        }
      }

    }
}
