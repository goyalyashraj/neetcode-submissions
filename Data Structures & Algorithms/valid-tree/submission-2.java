class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        boolean []vis= new boolean[n];
        if(edges.length!=n-1){
            return false;
        }
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[]node:edges){
            list.get(node[0]).add(node[1]);
             list.get(node[1]).add(node[0]);
        }
        for(int i =0;i<n;i++){
            if(!vis[i]){
                boolean found= dfs(i,vis,list,-1);
                if(found){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int curr, boolean[]vis, List<List<Integer>> list ,int par){
        vis[curr]=true;
        for(int n:list.get(curr)){
            if(vis[n]==true && par!=n){
                return true;
            }
            if(!vis[n]){
                if(dfs(n,vis,list,curr)){
                    return true;
                }
            }
        }
        return false;
    }
}
