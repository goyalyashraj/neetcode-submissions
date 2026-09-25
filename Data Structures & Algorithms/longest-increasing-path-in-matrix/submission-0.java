class Solution {
    int [][]dir={{0,1},{1,0},{-1,0},{0,-1}};
    int[][]dp;
        public int longestIncreasingPath(int[][] matrix) {
        int n =matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans,dfs(i,j,matrix));
            }
        }
        return ans;
    }
    public int dfs (int i , int j , int[][]matrix){
           int n =matrix.length;
        int m = matrix[0].length;
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int best =1;
        for(int []d:dir){
        
            int r= i+d[0];
            int c=j+d[1];
            if(r>=0 && c>=0 && r<n &&c<m && matrix[r][c]>matrix[i][j]){
                best= Math.max(best,1+dfs(r,c,matrix));
            }

        }
        dp[i][j]=best
        ;
        return best;
    }
}
