class LRUCache {
    class Node {
        Node next;
        Node previous;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> hashMap = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int actualCapacity;
    int currentCapacity = 0;
    
    public LRUCache(int capacity) {
        this.actualCapacity = capacity;
        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        Node node = hashMap.get(key);
        int value = node.value;
        deleteNode(node);
        addNode(node);
        hashMap.put(key, tail.previous);
        return value;
    }
    
    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            deleteNode(node);
            node.value = value;
            addNode(node);
            hashMap.put(key, tail.previous);
        }
        else if (currentCapacity < actualCapacity) {
            Node addNode = new Node(key, value);
            addNode(addNode);
            hashMap.put(key, tail.previous);
            currentCapacity++;
        }
        else {
            Node deleteNode = head.next;
            deleteNode(deleteNode);
            hashMap.remove(deleteNode.key);
            Node addNode = new Node(key, value);
            addNode(addNode);
            hashMap.put(key, tail.previous);
        }
    }
    
    private void addNode(Node addNode) {
        Node tailPrevious = tail.previous;
        tail.previous = addNode;
        addNode.next = tail;
        tailPrevious.next = addNode;
        addNode.previous = tailPrevious;
    }
    
    private void deleteNode(Node deleteNode) {
        Node deleteNodePrevious = deleteNode.previous;
        Node deleteNodeNext = deleteNode.next;
        deleteNodePrevious.next = deleteNodeNext;
        deleteNodeNext.previous = deleteNodePrevious;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */