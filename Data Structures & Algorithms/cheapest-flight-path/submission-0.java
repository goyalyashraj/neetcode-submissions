class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>>graph= new HashMap();
        for(int []flight:flights){
            int u = flight[0];
            int v= flight[1];
            int price= flight[2];

            if(!graph.containsKey(u)){
                graph.put(u,new ArrayList<>());
            }
            graph.get(u).add(new int []{v,price});
        }
        int []dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{src,0});
        int stop=0;
        while(!q.isEmpty()&&stop<=k){
            int size= q.size();
            for(int i=0;i<size;i++){
                int []curr= q.poll();
                int vtx= curr[0];
                int wt= curr[1];
                if(!graph.containsKey(vtx))continue;
                for(int []neigh:graph.get(vtx)){
                    int v=neigh[0];
                    int price= neigh[1];
                    int newPrice= price+wt;
                    if(newPrice<dist[v]){
                        dist[v]=newPrice;
                        q.offer(new int []{v,newPrice});
                    }
                }

            }
            stop++;
        }
        return dist[dst]==Integer.MAX_VALUE ?-1:dist[dst];
    }
}
