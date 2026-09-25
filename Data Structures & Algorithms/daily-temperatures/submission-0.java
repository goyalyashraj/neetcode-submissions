class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        int n = temperatures.length;
        int [] results = new int [n];
        for(int i =0 ;i<n;i++){
            while(!temp.isEmpty() && temperatures[i]>temperatures[temp.peek()]){
                int idx = temp.pop();
                results[idx] = i-idx;
            }
            temp.push(i);
        }
        return results;
        
    }
}
