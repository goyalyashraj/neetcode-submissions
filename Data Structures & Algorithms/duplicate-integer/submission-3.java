class Solution {
    public boolean hasDuplicate(int[] nums) {
   HashSet<Integer> num = new HashSet<>();
   for(int i =0;i<nums.length;i++){
    num.add(nums[i]);
   }
   if(num.size() == nums.length){
    return false;
   }
   return true;
    }
}