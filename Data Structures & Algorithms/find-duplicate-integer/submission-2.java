class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];         // tortoise moves 1 step
            fast = nums[nums[fast]];    // hare moves 2 steps
        } while (slow != fast);



         slow = nums[0];
           while(slow!=fast){
            //slow = nums[i];
            slow= nums[slow];
            fast = nums[fast];
           
//            return slow;
      }
         return slow;

    }
}
