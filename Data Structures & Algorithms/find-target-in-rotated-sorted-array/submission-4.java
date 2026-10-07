class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l =0;
        int r=n-1;
        while(r>l){
            int mid= (l+r)/2;

            if(nums[mid]>nums[r]){
                l= mid+1;
            }else{
                r=mid;
            }
        }
            int pivot=l;
            int result= binary(nums,target,0,pivot-1);
            if(result!=-1){
                return result;
            }
            return binary(nums,target,pivot,n-1);
        }
        public int binary(int[]nums,int target, int s, int e){
            int n = nums.length;
          while(e>=s){
            int mid = (s+e)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){

                s=mid+1;
            }else if(nums[mid]>target){
                e=mid-1;
            }
          }
          return -1;
        }
    }
