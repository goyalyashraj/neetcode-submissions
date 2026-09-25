class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>(); 
    public List<List<String>> partition(String s) {
       getAllParts(s,0);
       return ans;
    }
    public void getAllParts(String s,int index){
        if(index==s.length()){
         ans.add(new ArrayList<>(path));
         return;
        }
        for(int i=index;i<s.length();i++){
            if(ispalin(s,index,i+1)){
                path.add(s.substring(index,i+1));
                 getAllParts(s,i+1);
                 path.remove(path.size()-1);
            }
        }
    }
    

    public boolean ispalin(String s,int start,int end){
        while(start<end-1){
            if(s.charAt(start)!=s.charAt(end-1)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
