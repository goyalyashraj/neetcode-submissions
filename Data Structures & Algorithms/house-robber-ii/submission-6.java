class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int []front = new int[n-1];
        int []end = new int[n-1];
        for(int i=0;i<n-1;i++){
            front[i]= nums[i];
        }
         for(int i=0;i<n-1;i++){
            end[i]= nums[i+1];
        }
        return Math.max(solve(front),solve(end));

    }
    public int solve(int[]nums){
        int  n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[]dp = new int [n];
        dp[0]= nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]= Math.max(nums[i]+dp[i-2],dp[i-1]);
            }
            return dp[n-1];
    }
}

 