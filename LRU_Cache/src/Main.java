public class Main {
    public static void main(String[] var0) throws Exception {
        LRUCache cache = new LRUCache(4);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.put(4, 40);
        System.out.println("Get Key 1 -> " + cache.get(1));
        cache.printCache();

        System.out.println("Insert key 5 ( should evict LRU key 2 )");
        cache.put(5, 50);
        cache.printCache();

        System.out.println("Get key 2 -> " + cache.get(2));
        cache.printCache();

        System.out.println("Insert key 6 ( should evict LRU Key 3 )");
        cache.put(6, 60);
        cache.printCache();

        System.out.println("Get key 1 -> " + cache.get(1));
        cache.printCache();
    }
}
