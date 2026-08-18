class LRUCache {

    class Node{
        int key , val;
        Node prev, next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    HashMap<Integer,Node> map = new HashMap<>();

    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int res = node.val;

            deleteNode(node);
            insertNode(node);

            map.put(key,head.next);
            return res;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.val = value;

            deleteNode(node);
            insertNode(node);

            return;
        }
        else {
            if(map.size()==cap){
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            Node newNode = new Node(key,value);

            insertNode(newNode);
            map.put(key,head.next);
        }
    }

    public void insertNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    public void deleteNode(Node delNode){
        Node prevNode = delNode.prev;
        Node nextNode = delNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */