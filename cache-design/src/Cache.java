import Policies.EvictionPolicy;
import Storage.Storage;

public class Cache <Key,Value>{
    Storage<Key,Value> storage;
    EvictionPolicy<Key,Value> evictionPolicy;
    Cache(Storage<Key,Value> storage, EvictionPolicy<Key,Value> evictionPolicy){
        this.storage = storage;
        this.evictionPolicy=evictionPolicy;
    }

    void put(Key key, Value value){
        if(storage.isStorageFull()&& (!storage.ispresent(key))){
            Key keyRemoved = evictionPolicy.evictKey();
            storage.removeKey(keyRemoved);
        }
        storage.addValue(key,value);
        evictionPolicy.keyAccessed(key);
    }

    Value get(Key key){
        if(!storage.ispresent(key)){
            System.out.println("Key is not present");
            return null;
        }
        Value value = storage.getValue(key);
        evictionPolicy.keyAccessed(key);
        return value;
    }
}
