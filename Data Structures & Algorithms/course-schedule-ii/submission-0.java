class Solution {
    Stack<Integer>  s= new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int []neight:prerequisites){
            graph.get(neight[1]).add(neight[0]);
        }
        boolean []vis= new boolean[numCourses];
        boolean[]cycle= new boolean [numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(topsort(graph,vis,i,cycle)){
                    return new int[]{};
                }
            }
        }
        int []ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!s.isEmpty()){
                ans[i]= s.pop();
            }
        }
        return ans;
    }
    public  boolean topsort(List<List<Integer>>graph, boolean[]vis,int node,boolean[]cycle){
        vis[node]=true;
        cycle[node]=true;
        for(int next:graph.get(node)){
            if(!vis[next]){
               if (topsort(graph,vis,next,cycle)){
                return true;
               }
            }else if(cycle[next]){
                return true;
               }
        }
        s.push(node);
        cycle[node]=false;
        return false;
    }
}
