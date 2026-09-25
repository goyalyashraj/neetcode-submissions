class WordDictionary {
    class Node{
        Node[] children;
        boolean isWordEnd;
        public Node(){
            children=new Node[26];
            isWordEnd=false;
        }
    }
    Node root;
    public WordDictionary() {
        root=new Node();

    }

    public void addWord(String word) { 
        Node curr=root; 
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.isWordEnd=true;
    }

    public boolean search(String word) {
       return find(word,0,root);
    }
    public boolean find(String word,int i,Node curr){
                if (curr == null) return false;
            if(i == word.length()){
                return curr.isWordEnd;
            }
            if(word.charAt(i)=='.'){
                 for(int k=0;k<26;k++){
                    if(curr.children[k]!=null && find(word,i+1,curr.children[k])){
                        return true;
                    } 
            }
            return false;
        }
        else{
                int  idx = word.charAt(i)-'a';
                return find(word,i+1,curr.children[idx]);

            }            
    }
}
