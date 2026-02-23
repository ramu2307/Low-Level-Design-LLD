import java.util.HashMap;
public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy Node head and tail, to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = this.tail;
        tail.prev = this.head;
    }

    public int get(int key) {

        Node node = map.get(key);

        if(node == null) return -1;
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {

        Node node = map.get(key);

        // If Key already exists
        if (node != null) {
            node.value = value;
            remove(node);
            moveToFront(node);
        }

        // If cache full -> remove least recently used node
        if(map.size() == capacity) {
            Node lru = removeLast();
            map.remove(lru.key);
        }

        // Insert new node at front
        Node newNode = new Node(key, value);
        addFirst(newNode);
        map.put(key, newNode);
    }

    private Node removeLast() {
        Node lru = tail.prev;
        remove(lru);
        return lru;
    }

    private void moveToFront(Node node) {
        remove(node);
        addFirst(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    private void addFirst(Node node) {
        node.prev = this.head;
        node.next = this.head.next;

        head.next = node;
        node.next.prev = node;
    }

    public void printCache() {

        Node curr = head.next;
        System.out.print("Cache State ( MRU -> LRU ): ");
        while (curr != tail) {
            System.out.print("[" + curr.key + ":" + curr.value + "] ");
            curr = curr.next;
        }
        System.out.println();
    }
}
