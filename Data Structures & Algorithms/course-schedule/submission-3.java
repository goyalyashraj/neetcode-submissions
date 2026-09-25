class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] q : prerequisites) {
            list.get(q[1]).add(q[0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] res = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, list, prerequisites, vis, res)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(
        int n, List<List<Integer>> list, int[][] prerequisites, boolean[] vis, boolean[] res) {
        vis[n] = true;
        res[n] = true;
        for (int neigh : list.get(n)) {
            if (!vis[neigh]) {
                if (dfs(neigh, list, prerequisites, vis, res)) {
                    return true;
                }
            } else if (res[neigh]) {
                return true;
            }
        }
        res[n] = false;
        return false;
    }
}
