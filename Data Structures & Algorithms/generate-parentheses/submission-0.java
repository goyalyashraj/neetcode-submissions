class Solution {
    List<String> result = new ArrayList<>();
   
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n,"");
        return result;
    }

    public void backtrack(int open ,int close,int n , String s){
        if(s.length()==2*n){
            result.add(s);
            return;
        }
        if(open <n){
            backtrack(open+1,close,n,s+"(");
        }
        if(close<open){
             backtrack(open,close+1,n,s+")");
        }
        
    }
}
