class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int[][]sortedQ= new int[m][2];
        for(int i =0;i<m;i++){
            sortedQ[i][0]=queries[i];
            sortedQ[i][1]=i;
        }
          Arrays.sort(sortedQ,(a,b)->Integer.compare(a[0],b[0]));
          PriorityQueue<int[]>heap= new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
          int[]ans = new int[m];
          for(int i=0;i<m;i++){
            Arrays.fill(ans,-1);
          }
          int i=0;
          for(int[]q:sortedQ){
            int qv= q[0];
            int index=q[1];

            while(i<n && qv>=intervals[i][0]){
                int left = intervals[i][0];
                int right = intervals[i][1];
                int size= right-left+1;
                heap.offer(new int[]{size,right});
                i++;
            }
            while(!heap.isEmpty() && heap.peek()[1]<qv){
                heap.poll();
            }

            if(!heap.isEmpty()){
                ans[index]=heap.peek()[0];
            }

          }
          return ans;
    }
}
