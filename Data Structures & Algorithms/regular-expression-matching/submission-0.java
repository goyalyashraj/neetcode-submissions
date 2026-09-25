class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m =p.length();
        boolean[][]dp=new boolean[n+1][m+1];
        dp[0][0]=true;
      for(int c = 2; c <= m; c++) {
    if(p.charAt(c - 1) == '*') {
        dp[0][c] = dp[0][c - 2];
    }
}
        for(int r=1;r<=n;r++){
            for(int c=1;c<=m;c++){
                if(s.charAt(r-1)==p.charAt(c-1)||p.charAt(c-1)=='.'){
                    dp[r][c]=dp[r-1][c-1];
                }
              if(p.charAt(c-1)=='*'){
                    dp[r][c]=dp[r][c-2];
                    if(s.charAt(r-1)==p.charAt(c-2)||p.charAt(c-2)=='.'){
                        dp[r][c]=dp[r-1][c] || dp[r][c];
                    }
                }
            }
        }
        return dp[n][m];
        
    }
}
