class LRUCache {

    HashMap<Integer, Node> hs;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hs = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (hs.containsKey(key)) {
            Node node = hs.get(key);
            DeleteNode(node);
            addAfterHead(node);
            return hs.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (hs.containsKey(key)) {
            Node node = hs.get(key);
            node.val = value;
            DeleteNode(node);
            addAfterHead(node);
        } else {
            if (hs.size() == capacity) {
                int temp = tail.prev.key;
                if (hs.containsKey(temp)) {
                    hs.remove(temp);
                }
                DeleteNode(tail.prev);
            }
            Node node = new Node(key, value);
            addAfterHead(node);
            hs.put(key, node);
        }
    }

    public void DeleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return;
    }

    public void addAfterHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        return;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */