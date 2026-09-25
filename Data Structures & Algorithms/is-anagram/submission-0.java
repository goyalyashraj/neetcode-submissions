class Solution {
    public boolean isAnagram(String s, String t) {
        char [] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        String ss = new String(arr1);

         char [] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        String tt = new String(arr2);

        if(ss.equalsIgnoreCase(tt)){
            return true;
        }
        else{
            return false ;
        }
    }
}
