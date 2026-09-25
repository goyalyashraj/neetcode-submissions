class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp =new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }
                  else  {
                    int left=0;
                    int top=0;
                    if(j>0){
                         left =dp[i][j-1];
                    }
                    if(i>0){
                         top=dp[i-1][j];
                    }
                    dp[i][j]= top+left;}
            }
        }
        return dp[n-1][m-1];
    }
}
