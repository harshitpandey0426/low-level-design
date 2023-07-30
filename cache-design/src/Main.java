public class Main {
    public static void main(String[] args) {
        CacheFactory cacheFactory = new CacheFactory();
        Cache cache = cacheFactory.defaultCache(5);

        cache.put(5,8);
        cache.put(6,9);
        cache.put(7,10);
        cache.put(8,11);
        cache.put(9,12);
        cache.put(10,13);
        cache.put(11,14);
        cache.put(7,14);
        cache.put(12,14);
        cache.get(9);
        cache.put(13,19);



        System.out.println("Key value is: "+ cache.get(10));


    }
}