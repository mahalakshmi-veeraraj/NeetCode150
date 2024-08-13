class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node previous;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> hashMap = new HashMap<>();
    int actualCapacity = 0;
    int currentCapacity = 0;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.previous = head;
        actualCapacity = capacity;
    }
    
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        Node node = hashMap.get(key);
        deleteNode(node);
        hashMap.remove(key);
        addNode(node);
        hashMap.put(key, tail.previous);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            deleteNode(node);
            hashMap.remove(key);
            node.value = value;
            addNode(node);
            hashMap.put(key, tail.previous);
        }
        else if (currentCapacity < actualCapacity) {
            Node newNode = new Node(key, value);
            addNode(newNode);
            hashMap.put(key, tail.previous);
            currentCapacity++;
        }
        else {
            Node newNode = new Node(key, value);
            Node deleteNode = head.next;
            deleteNode(deleteNode);
            hashMap.remove(deleteNode.key);
            addNode(newNode);
            hashMap.put(key, tail.previous);
        }
    }
    
    private void addNode(Node newNode) {
        Node tailPrevious = tail.previous;
        tailPrevious.next = newNode;
        newNode.previous = tailPrevious;
        newNode.next = tail;
        tail.previous = newNode;
    }
    
    private void deleteNode(Node deleteNode) {
        Node deleteNodePrevious = deleteNode.previous;
        deleteNodePrevious.next = deleteNode.next;
        deleteNode.next.previous = deleteNodePrevious;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */