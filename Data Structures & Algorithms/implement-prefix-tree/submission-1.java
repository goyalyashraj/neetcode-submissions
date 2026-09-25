class PrefixTree {
    class TreeNode{
        TreeNode[]children ;
        boolean isEndWord;
        public TreeNode(){
            this.children = new TreeNode[26];
            this.isEndWord= isEndWord;
        }
    }
    private TreeNode root; 

    public PrefixTree() {
         root= new TreeNode();
    }

    public void insert(String word) {
      
        TreeNode curr = root;
        for(int i=0;i<word.length();i++){
              char ch = word.charAt(i);
            int ii= ch-'a';
            if(curr.children[ii]==null){
                curr.children[ii]= new TreeNode();
            }
            curr =  curr.children[ii];
        }
        curr.isEndWord=true;
    }

    public boolean search(String word) {

        TreeNode curr = root;
        for(int i=0;i<word.length();i++){
        char ch = word.charAt(i);
            int ii= ch-'a';
            if(curr.children[ii]==null){
                return false;
            }
            curr =  curr.children[ii];
        }
        return curr.isEndWord;


    }

    public boolean startsWith(String prefix) {

        TreeNode curr = root;
        for(int i=0;i<prefix.length();i++){
              char ch = prefix.charAt(i);
            int ii= ch-'a';
            if(curr.children[ii]==null){
               return false;
            }
            curr =  curr.children[ii];
        }
        return true;

    }
}
