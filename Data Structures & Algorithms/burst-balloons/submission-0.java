class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int []num= new int[n+2];
        num[0]=1;
        num[n+1]=1;
        for(int i=0;i<n;i++){
            num[i+1]=nums[i];
        }
        int [][]dp = new int [n+2][n+2];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                int k = i+j-1;
                for(int left =j;left<=k;left++){
                    dp[j][k]= Math.max(dp[j][left-1]+num[j-1]*num[left]*num[k+1]+dp[left+1][k],dp[j][k]);
                }
            }

        }
       return dp[1][n];
        
    }
}
