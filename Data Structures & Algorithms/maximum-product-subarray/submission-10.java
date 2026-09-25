class Solution {
    public int maxProduct(int[] nums) {
        int n =  nums.length;
        int[]max = new int [n+1];
        int[]min = new int[n+1];
        int ans=0;
        if(n==1){
            return nums[0];
        }

        max[0]= nums[0];
        min[0] = nums[0];
        for(int i=1;i<n;i++){
            max[i]= Math.max(nums[i],Math.max(nums[i]*max[i-1],nums[i]*min[i-1]));
            min[i]=Math.min(nums[i],Math.min(nums[i]*max[i-1],nums[i]*min[i-1]));
            ans= Math.max(ans,max[i]); 
        }
        return ans ;
    }
}
