class Solution {
    class Pair{
        int step;
        String str;
        public Pair(int step,String str){
            this.str=str;
            this.step=step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n= wordList.size();
        
        HashSet<String> set = new HashSet<>();
        Queue<Pair> q =new LinkedList<>();
        for(int i=0;i<n;i++){
            set.add(wordList.get(i));
        }
        q.offer(new Pair(1,beginWord));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair next =q.poll();
            int count= next.step;
            String string = next.str;
            if(string.equals(endWord)==true)return count;
            for(int i=0;i<string.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replace=string.toCharArray();
                    replace[i]=ch;
                    String replaceWord= new String(replace);
                    if(set.contains(replaceWord)){
                        set.remove(replaceWord);
                        q.offer(new Pair(count+1,replaceWord));
                    }
                }
            }
            
            
        }

       return 0; 
    }
}
