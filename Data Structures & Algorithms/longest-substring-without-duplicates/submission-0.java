class Solution {
    public int lengthOfLongestSubstring(String s) {
        
    //     char arr[] =s.toCharArray();
    // HashSet<Character> ss = new HashSet<>();
    // for (char c:arr){
    //     ss.add(c);
    // }
    // return ss.size();

    int left = 0;
    int maxlen =0;
    HashSet<Character> ss = new HashSet<>();
    for(int r =0;r< s.length();r++){
     
        while(ss.contains(s.charAt(r))){
            ss.remove(s.charAt(left));
            left++;
        }
        ss.add(s.charAt(r));
        maxlen = Math.max(maxlen,r-left+1);

    }
    return maxlen;
    }
}
