import Policies.LRUPolicy;
import Storage.HashMapStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new HashMapStorage<Key, Value>(capacity),new LRUPolicy<Key,Value>());
    }
}