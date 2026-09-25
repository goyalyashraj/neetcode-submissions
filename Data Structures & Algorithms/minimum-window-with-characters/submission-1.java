class Solution {
    public String minWindow(String s, String t) {
    //      if (s.length() < t.length()) return "";
    //     HashMap<Character,Integer> tt =new HashMap<>();
    //     for(char c: t.toCharArray()){
    //         tt.put(c,tt.getOrDefault(c,0)+1);
    //     }
    //     int need = t.length();
    //     int right =0;
    //     int left =0;
    //     int start=0;

    //     int minlen=Integer.MAX_VALUE;
    //     while(right<s.length()){
    //         char c = s.charAt(right);
    //        if (tt.containsKey(c)){
    //             if(tt.get(c)>0){
    //                 need--;
    //             }
    //             tt.put(c,tt.get(c)-1);
    //         }
    //         right++;
        
    //     while(need==0){
    //         if(right-left<minlen){
    //             minlen= right -left;
    //             start = left;
    //         }
    //         char c1= s.charAt(left);
           
    //         if (tt.containsKey(c1)) {
    //             tt.put(c1, tt.get(c1) + 1);
    //              if(tt.get(c1)>0){
    //                 need++;
    //             }
    //         }
    //              left++;
    //     }
    //     }
       
    //      return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    if(s.length() <t.length()){return "";}
    HashMap<Character,Integer> map = new HashMap<>();
    for(char c :t.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
    }
    int need =t.length();
    int right =0;
    int left = 0;
    int start=0;
    int  minlen =Integer.MAX_VALUE;
    while (right<s.length()){
        char c = s.charAt(right);
        if(map.containsKey(c)){
            if(map.get(c)>0){
                need--;
            }
            map.put(c,map.get(c)-1);
        }
        right++;
        while(need ==0){
               if(right-left <minlen){
                  minlen = right-left;
                  start = left ;
                }
                char c1= s.charAt(left);
                if(map.containsKey(c1)){
                    map.put(c1,map.get(c1)+1);
                    if(map.get(c1)>0){
                        need++;
                    }
                }
                left++;
        }
    }
    return minlen == Integer.MAX_VALUE  ? "" : s.substring(start,start+minlen);
     }
}
