class LRUCache {
    class Node{
        Node next ,prev;
        int val , key;
        public Node(int key , int val ){
            this.key =key;
            this.val = val;
        }   
    }
    private  int capacity ;
    HashMap<Integer,Node> map ;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
          Node node =  map.get(key);
          remove(node);
          insertAtHead(node);
          return node.val;
        }
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
              Node node =  map.get(key);
              node.val=value;
          remove(node);
          insertAtHead(node);
          return;
        }
        if(map.size()== capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key,value);
        insertAtHead(newNode);
        map.put(key,newNode);
        
    }
    private void remove(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;
    }
   private void insertAtHead(Node node){
        node.prev = head;
        node.next= head.next;
        head.next.prev= node;
        head.next =node;
    }
}
