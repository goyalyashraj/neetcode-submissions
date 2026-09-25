class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int max= amount+1;
        int[][]dp = new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
           for(int i=0;i<=amount;i++){
            dp[0][i]=max;;
        }
        for(int i=1;i<=n;i++){
            int curr=coins[i-1];
            for(int j=1;j<=amount;j++){
                if(j>=curr){
                    dp[i][j]= Math.min(dp[i-1][j],dp[i][j-curr]+1);
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][amount]>amount?-1:dp[n][amount];
    }
}
