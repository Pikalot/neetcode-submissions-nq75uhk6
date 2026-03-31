class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        // Move node to last
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));

        Node node = new Node(key, value);
        cache.put(key, node);
        add(node);

        if (cache.size() > capacity) {
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void add(Node node) {
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

class Node {
    private int key;
    private int val;
    private Node prev;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
        this.prev = null;
        this.next = null;
    }
}
