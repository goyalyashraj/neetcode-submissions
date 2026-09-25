class Solution {
    public boolean isPalindrome(String s) {
        String ss= s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String rev ="";
        for(int i =ss.length()-1;i>=0;i--){
            rev += ss.charAt(i);
        }
     return ss.equals(rev);   
    }

}
