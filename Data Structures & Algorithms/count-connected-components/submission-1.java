class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public int countComponents(int n, int[][] edges) {
        boolean []vis = new boolean[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[]pair :edges){
            list.get(pair[0]).add(pair[1]);
            list.get(pair[1]).add(pair[0]);
        }
        int count =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,list,vis);
            }
        } 
        return count;
    }
    public void dfs(int node,List<List<Integer>>list,boolean[]vis){
        
        vis[node]= true;
        for(int i : list.get(node)){
            if(!vis[i]){
                dfs(i,list,vis);
            }
        }
    }
}
