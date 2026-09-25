class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target) > sum||(sum+target)%2!=0){
            return 0;
        }
        int first= (sum+target)/2;
        int [][]dp =new int[nums.length+1][first+1];
        dp[0][0]=1;
        for(int i=1;i<=nums.length;i++){
            int curr= nums[i-1];
            for(int j=0;j<=first;j++){
                if(curr<=j){
                    dp[i][j]= dp[i-1][j]+dp[i-1][j-curr];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][first];
    }
}
