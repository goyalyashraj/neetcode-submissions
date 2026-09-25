class Solution {
    public boolean hasDuplicate(int[] nums) {
 HashMap<Integer,Integer> num = new HashMap<>();
 for(int i=0;i<nums.length;i++){
    num.put(nums[i],num.getOrDefault(nums[i],0)+1);
 }
 for(Map.Entry<Integer,Integer> entry: num.entrySet()){
    if(entry.getValue()>1){
        return true;
    }
    
 }
 return false;
    }
}