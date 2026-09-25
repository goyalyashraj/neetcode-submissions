class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0);
        return ans;
    }
    public  void backtrack(int[] nums, int target, int index){
          if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
     for (int i = index;i < nums.length; i++) {
      
        if (i > index && nums[i] == nums[i - 1]) {
            continue;
        }
        path.add(nums[i]);
        backtrack(nums, target - nums[i], i);
         path.remove(path.size() - 1);
    }
}
}
