class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> ss1 = new HashMap<>();
        

        for(char c : s1.toCharArray()){
            ss1.put(c,ss1.getOrDefault(c,0)+1);
        }
        int need = ss1.size();


       for(int i =0;i<s2.length();i++){
        int curr =0;
        HashMap<Character,Integer>ss2 = new HashMap<>();

        for(int j=i;j<s2.length();j++){
            char c= s2.charAt(j);
        ss2.put(c,ss2.getOrDefault(c,0)+1);

        if(ss1.getOrDefault(c,0) < ss2.get(c)){
            break;
        }
        if(ss1.getOrDefault(c,0) == ss2.get(c)){
            curr++;
        }
        if(need==curr){

            return true ;
        }
     }
     }
     return false;
    }
}
