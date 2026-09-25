class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());

        int totalTime=0;
        int size = tasks.length;
        int block=n+1;
        int [] feq = new int[26];
        for(char c :tasks){
            feq[c-'A']++;
        }
        for(int f:feq){
           if(f>0) q.offer(f);
        }
       
     while (!q.isEmpty()){
        List<Integer> list = new ArrayList<>();
         int task =0;
         for(int i=0;i<n+1;i++)
       { if(!q.isEmpty()){
            int count = q.poll();
            count--;
            task++;
            if(count>0){
                list.add(count);
            }
        }}
        q.addAll(list);

      
        totalTime += q.isEmpty()? task : n+1;}
        
        return totalTime;
    }
}
