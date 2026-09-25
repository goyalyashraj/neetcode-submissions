    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtack(0,target,candidates);
            return result ;
        }

        public void backtack(int index , int target, int []candidates ){
            
            if(target==0){
                result.add(new ArrayList(path));
                return;
            }
            if(target<0 || index>=candidates.length){
                return;
            }
            path.add(candidates[index]);
            backtack(index+1,target-candidates[index],candidates);
            path.remove(path.size()-1);
            while(index+1<candidates.length  && candidates[index]==candidates[index+1]){
                index++;
            }
            backtack(index+1,target,candidates);
        }
    }







































  