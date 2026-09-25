class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int index, int[]nums,  List<Integer>path,   List<List<Integer>>result ){
        if(index==nums.length){
            result.add(new ArrayList(path));
            return ;
        }
        path.add(nums[index]);
        backtrack(index+1,nums,path,result);
        index= index+1;
        while(index<nums.length &&nums[index]==nums[index-1]){
            index++;
        }
        path.remove(path.size()-1);
         backtrack(index,nums,path,result);
    }
}
