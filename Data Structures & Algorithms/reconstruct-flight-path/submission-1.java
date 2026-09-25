class Solution {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> list = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }
        dfs("JFK");
        return list;
    }
    public void dfs(String str) {
        PriorityQueue<String> q = map.get(str);
        while (q != null && !q.isEmpty()) {
            String strs = q.poll();
            dfs(strs);
        }
        list.addFirst(str);
    }
}
