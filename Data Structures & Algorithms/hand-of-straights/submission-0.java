class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0){return false;}
        TreeMap<Integer,Integer> map= new TreeMap<>();
        for(int hands:hand){
            map.put(hands,map.getOrDefault(hands,0)+1);
        }
        while(!map.isEmpty()){
        int start = map.firstKey();
        for(int i=0;i<groupSize;i++){
            int next = i+start;
            if(!map.containsKey(next)){
                return false;
            }
            map.put(next,map.get(next)-1);
            if(map.get(next)==0){
                map.remove(next);
            }
        }
        }
        return true;
    }
}



