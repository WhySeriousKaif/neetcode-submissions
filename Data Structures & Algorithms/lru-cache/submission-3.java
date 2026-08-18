

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;

    // Dummy nodes
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // head <-> ... <-> tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Add node just after head
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move an existing node to front = Most Recently Used
    private void makeRecentlyUsed(Node node) {
        removeNode(node);
        addToFront(node);
    }

    public int get(int key) {

        // Key doesn't exist
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // It was just accessed, so make it MRU
        makeRecentlyUsed(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.value = value;

            // Recently updated => MRU
            makeRecentlyUsed(node);

            return;
        }

        // Create new node
        Node newNode = new Node(key, value);

        // Add to HashMap
        map.put(key, newNode);

        // New node = Most Recently Used
        addToFront(newNode);

        // Cache exceeded capacity
        if (map.size() > capacity) {

            // Least Recently Used is just before tail
            Node lru = tail.prev;

            removeNode(lru);

            map.remove(lru.key);
        }
    }
}