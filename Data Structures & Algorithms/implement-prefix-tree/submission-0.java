class PrefixTree {
    class Node{
        Node[]children;
        boolean isWordEnd;
        public Node(){

            children = new Node[26];
            isWordEnd=false;
        }
    }
Node root;
    public PrefixTree() {
        root= new Node();
         
    }

    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i) -'a';
            if(node.children[idx]==null){
                node.children[idx]=new Node();
            }
            node=node.children[idx];
        }
        node.isWordEnd=true;
    }

    public boolean search(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
             curr=curr.children[idx];
        }
        return curr.isWordEnd;

    }

    public boolean startsWith(String prefix) {
          Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;



    }
}
