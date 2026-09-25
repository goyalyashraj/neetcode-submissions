class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            q.offer(stone);
        }
        while(q.size()>1){int x = q.poll();
        int y = q.poll();
        if(x!=y){
            q.offer(Math.abs(x-y));
        }}
        return q.isEmpty()?0:q.poll();

    }
}
