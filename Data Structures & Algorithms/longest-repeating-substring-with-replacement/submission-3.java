class Solution {
    public int characterReplacement(String s, int k) {
        int res =0;
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        for(char c : set){
           int count =0;
            int left =0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==c){
                    count++;
                }

                while((i-left+1) - count >k){
                     if(s.charAt(left)==c){
                    count--;
                }
                left++;
                }
                 res = Math.max(res,i-left+1);

            }
            
        }
           return res;
    }
}
