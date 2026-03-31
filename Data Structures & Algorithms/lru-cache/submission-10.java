class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node dummyHead;
    private Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dummyHead = new Node(0, 0);
        this.dummyTail = new Node(0, 0);
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }
    
    public int get(int key) {
        if (!this.cache.containsKey(key)) return -1;

        Node node = this.cache.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (this.cache.containsKey(key)) remove(this.cache.get(key));
        this.cache.put(key, node);
        add(node);

        if (this.cache.size() > this.capacity) {
            Node nodeLRU = dummyHead.next;
            this.cache.remove(nodeLRU.key);
            remove(nodeLRU);
        }
    }

    private void add(Node node) {
        Node prev = dummyTail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = dummyTail;
        dummyTail.prev = node;
    }

    private boolean remove(Node node) {
        if (node == null) return false;

        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        return true;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.prev = null;
            this.next = null;
        }
    }
}
