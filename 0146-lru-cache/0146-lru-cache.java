class LRUCache {
    class Node {
        Node next;
        Node previous;
        int key;
        int value;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }
    
    Map<Integer, Node> hashMap;
    int currentCapacity;
    int actualCapacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        hashMap = new HashMap<>();
        currentCapacity = 0;
        actualCapacity = capacity;
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
        hashMap.remove(node.key);
        addNode(node);
        hashMap.put(key, tail.previous);
        return value;
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
            Node node = new Node(key, value);
            addNode(node);
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
        addNode.previous = tailPrevious;
        tailPrevious.next = addNode;
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