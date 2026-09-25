class Solution {
    int[]parent;
    int[] rank; 
    public int find(int  node){
        if(parent[node]!=node){
          return  find(parent[node]);
        }
        return parent[node];
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        parent= new int[n+1];
        rank = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[]e:edges){
            int u=find(e[0]);
            int v=find(e[1]);

            if(u==v){
                return e;
            }
            if(rank[u]>rank[v]){
                parent[v]=u;
            }
            else if(rank[v]>rank[u]){
                parent[u]=v;
            }
            else{
                parent[v]=u;
                rank[u]++;
            }
        }
        return new int[0];
    }
}
