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
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh =0;
        Queue<Pair>q= new LinkedList<>();
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==2){
                    q.add(new Pair(r,c,0));
                }
                if(grid[r][c]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)return 0;
        return bfs(grid,q,fresh);
    }
    public int bfs(int[][]grid, Queue<Pair>q,int fresh){
         int m = grid.length;
        int n = grid[0].length;
        int max =0;
        while(!q.isEmpty()){
            Pair curr= q.poll();
            int t= curr.t;
            int r = curr.r;
            int c=curr.c;
            max = Math.max(max,t);
            if(r-1>=0&& grid[r-1][c]==1){
                grid[r-1][c]=2;
                fresh--;
                q.add(new Pair(r-1,c,t+1));
            }
             if(r+1<m && grid[r+1][c]==1){
                grid[r+1][c]=2;
                fresh--;
                q.add(new Pair(r+1,c,t+1));
            }
             if(c-1>=0&& grid[r][c-1]==1){
                grid[r][c-1]=2;
                fresh--;
                q.add(new Pair(r,c-1,t+1));
            }
             if(c+1<n&& grid[r][c+1]==1){
                grid[r][c+1]=2;
                fresh--;
                q.add(new Pair(r,c+1,t+1));
            }
        }
        return fresh==0 ? max :-1;
    }
}
