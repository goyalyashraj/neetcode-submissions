class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character,HashSet<Character>> adj = new HashMap<>();
      HashMap<Character,Integer>inDegree= new HashMap<>();

      for(String word:words){
        for(char c: word.toCharArray()){
            adj.putIfAbsent(c, new HashSet<>());
            inDegree.putIfAbsent(c,0);
 
        }
      }
      for(int i=0;i<words.length-1;i++){
        String w1= words[i];
        String w2= words[i+1];
        if(w2.length()<w1.length() && w1.startsWith(w2)){
            return "";
        }
        int min= Math.min(w2.length(),w1.length());
        for(int r=0;r<min;r++){
            char c1= w1.charAt(r);
            char c2= w2.charAt(r);
            if(c1!=c2){
                if(!adj.get(c1).contains(c2)){
                    adj.get(c1).add(c2);
                    inDegree.put(c2,inDegree.get(c2)+1);
                }
                break;
            }

        }
      }

      Queue<Character> q= new LinkedList<>();
      for(char c :inDegree.keySet()){
        if(inDegree.get(c)==0){
            q.offer(c);
        }
      }
      StringBuilder str = new StringBuilder();
      while(!q.isEmpty()){
        char curr= q.poll();
        str.append(curr);

        for(char neighbor:adj.get(curr)){
            inDegree.put(neighbor, inDegree.get(neighbor) - 1);
           
                if (inDegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
        }
      }
      if (str.length() < inDegree.size()) {
            return "";
        }

        return str.toString();
    }
}
