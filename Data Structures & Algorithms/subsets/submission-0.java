class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backstrack(0,nums,new ArrayList<>(),result);
        return result;
    }
    public static void backstrack(int index,int[]nums,List<Integer>path,List<List<Integer>>res){
        if(index==nums.length){
            res.add(new ArrayList(path));
            return;
        }
        path.add(nums[index]);
         backstrack(index+1,nums,path,res);
         path.remove(path.size()-1);
          backstrack(index+1,nums,path,res);
    }
}
