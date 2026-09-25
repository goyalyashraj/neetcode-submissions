// class Solution {
//     List<String> res = new ArrayList<>();
//     public List<String> letterCombinations(String digits) {
//         if(digits.isEmpty()){
//             return res;
//         }
//         backtrack("",digits);
//         return res;
//     }
//     public void backtrack(String p,String up){
//         if(up.isEmpty()){
//             res.add(p);
//             return ;
//         }
//         int s = up.charAt(0) -'0';
//         for(int i=(s-2)*3;i<(s-1)*3;i++){
//             char ch = (char)('a'+i);
//             backtrack(p+ch,up.substring(1));
//         }

//     }
// }

class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {
    "", "",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz"
};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        backtrack("",digits);
        return res;
    }
    public void backtrack(String p,String up){
        if(up.isEmpty()){
            res.add(p);
            return ;
        }
        int s = up.charAt(0) -'0';
        String letters = map[s];
        for(int i=0;i<letters.length();i++){
            char ch = letters.charAt(i);
            backtrack(p+ch,up.substring(1));
        }

    }
}
