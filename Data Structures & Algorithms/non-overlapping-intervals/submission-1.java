class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int n =intervals.length;
        int start=intervals[0][0];
        int end = intervals[0][1];
        int count=1;
        for(int i=1;i<n;i++){
            if(end<=intervals[i][0]){
                end= Math.max(intervals[i][1],end);
                count++;
                end=intervals[i][1];
            }
        }
        return n-count;
    }
}
