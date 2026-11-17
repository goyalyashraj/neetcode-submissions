class Solution {
    public int findDuplicate(int[] nums) {
        int l = nums.length;
        int num=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
             if(map.get(n)==2){
                return n;
             }
        }
        return -1 ;
      
    }
}
