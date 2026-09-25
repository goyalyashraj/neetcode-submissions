class Solution {
    public boolean isAnagram(String s, String t) {
        // char [] arr1 = s.toCharArray();
        // Arrays.sort(arr1);
        // String ss = new String(arr1);

        //  char [] arr2 = t.toCharArray();
        // Arrays.sort(arr2);
        // String tt = new String(arr2);

        // if(ss.equalsIgnoreCase(tt)){
        //     return true;
        // }
        // else{
        //     return false ;
        // }
        if(s.length()!= t.length()){
            return false ;
        }

        HashMap<Character,Integer> ss = new HashMap<>();
       for (int i=0;i< s.length();i++){
        char c = s.charAt(i);
        ss.put(c,ss.getOrDefault(c,0)+1);
       }
       for(int i=0;i<t.length();i++){
        char c = t.charAt(i);
        if(!ss.containsKey(c) || ss.get(c)==0 ){
            return false;
        }else{
            ss.put(c,ss.get(c)-1);
        }


       }
       return true ;
    
    }
}
