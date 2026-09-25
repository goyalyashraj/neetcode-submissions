class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

 
    int left = 0;
    List<Integer> l1 = new ArrayList<>();
    List <Integer> lc = new ArrayList<>();

    for(int right =0 ;right<nums.length;right++){
         lc.add(nums [right]);
        while (right -left+1== k){
            int max = Collections.max(lc);
            l1.add(max);
           lc.remove(0);
           left++;
        }
    }
    
        int[] result = new int[l1.size()];
        for (int i = 0; i < l1.size(); i++) {
                result[i] = l1.get(i);
            }

    return result ;

        
    }
}
