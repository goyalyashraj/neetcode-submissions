class Solution {
    class Pair implements Comparable<Pair>{
        int weight;
        int vertex;
        public Pair(int weight,int vertex){
            this.weight= weight;
            this.vertex=vertex;
        }
        @Override
        public int compareTo(Pair p2){
            return this.weight-p2.weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair>q= new PriorityQueue<>();
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]neigh:times){
            int u=neigh[0];
            int v= neigh[1];
            int t=neigh[2];
            graph.get(u).add(new Pair(t,v));
        }
        int []dis= new int[n+1];
        for(int i=0;i<dis.length;i++ ){
          if(i!=k)  {dis[i]=Integer.MAX_VALUE;}
        }
        q.offer(new Pair(0,k));
        while(!q.isEmpty()){
            Pair curr= q.poll();
            int v= curr.vertex;
            int t= curr.weight;
            if(t>dis[v]){
                continue;
            }
            for(Pair next:graph.get(v)){
                int neigh=next.vertex;
                int wt= next.weight;

                if(dis[v]+wt<dis[neigh]){
                    dis[neigh]=dis[v]+wt;
                    q.offer(new Pair(dis[neigh],neigh));
                }

            }
        }
        int res= 0;
            for(int i=1;i<=n;i++){
                if(dis[i]==Integer.MAX_VALUE){
                    return -1;
                }
                res= Math.max(res,dis[i]);
            }
        return res;
    }
}
