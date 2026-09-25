class Solution {
   class Pair implements Comparable<Pair>{
        int vertex;
        int weight;
        public Pair(int vertex, int weight){
            this.vertex= vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Pair weight2){
            return this.weight-weight2.weight;
        }
    }
public int dist(int[][]points, int p1, int p2){
            return Math.abs(points[p1][0]-points[p2][0])+Math.abs(points[p1][1]-points[p2][1]);
        }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> q= new PriorityQueue<>();
        int n = points.length;
        boolean[]vis = new boolean[n];
        int cost =0;
        int count=0;
        
        q.offer(new Pair(0,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int ver= curr.vertex;
            int wt = curr.weight;
            if(vis[ver]){
                continue;
            }
            vis[ver]= true;
            cost+=wt;
            for(int i=0;i<n;i++){
                int dis=dist(points,ver,i);
                q.offer(new Pair(i,dis));
            }

        }
        return cost;
        
    }
}
