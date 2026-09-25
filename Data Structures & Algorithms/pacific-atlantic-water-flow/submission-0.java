class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m= heights[0].length;
    boolean[][]p = new boolean[n][m];
    boolean [][]a = new boolean[n][m];
    List<List<Integer>> list = new ArrayList<>();
    for(int r=0;r<n;r++){
        dfs(r,0,p,heights);
    }
    for(int r=0;r<n;r++){
        dfs(r,m-1,a,heights);
    }
    for(int c=0;c<m;c++){
        dfs(0,c,p,heights);
    }
    for(int c=0;c<m;c++){
        dfs(n-1,c,a,heights);
    }

    for(int r=0;r<n;r++){
        for(int c=0;c<m;c++){
            if(p[r][c]&&a[r][c]){
                list.add(Arrays.asList(r,c));
            }
        }
    }
    return list;
    }
    public static void dfs(int r, int c, boolean[][]vis, int [][]heights){
        int n = heights.length;
        int m= heights[0].length;
        vis[r][c]=true;
        int[][]direction = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] i:direction){
            int nr= r +i[0];
            int nc= c+i[1];

            if(nr>=0&&nr<n&&nc>=0&&nc<m && !vis[nr][nc]&& heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,vis,heights);
            }
        }
        
    }
}
