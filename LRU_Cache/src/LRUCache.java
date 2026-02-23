import java.util.HashMap;
public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    Node head;
    Node tail;

    LRUCache(int var1) {
        this.capacity = var1;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int var1) throws Exception {
        Node var2 = (Node)this.map.get(var1);
        if (var2 == null) {
            return -1;
        } else {
            this.moveToFront(var2);
            return var2.value;
        }
    }

    public void put(int var1, int var2) {
        Node var3 = (Node)this.map.get(var1);
        if (var3 != null) {
            var3.value = var2;
            this.remove(var3);
            this.moveToFront(var3);
        } else {
            Node var4;
            if (this.map.size() == this.capacity) {
                var4 = this.removeLast();
                this.map.remove(var4.key);
            }

            var4 = new Node(var1, var2);
            this.addFirst(var4);
            this.map.put(var1, var4);
        }
    }

    private Node removeLast() {
        Node var1 = this.tail.prev;
        this.remove(var1);
        return var1;
    }

    private void moveToFront(Node var1) {
        this.remove(var1);
        this.addFirst(var1);
    }

    private void remove(Node var1) {
        var1.prev.next = var1.next;
        var1.next.prev = var1.prev;
        var1.prev = null;
        var1.next = null;
    }

    private void addFirst(Node var1) {
        var1.prev = this.head;
        var1.next = this.head.next;
        this.head.next = var1;
        var1.next.prev = var1;
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
