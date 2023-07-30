package Storage;

import java.util.HashMap;

public class HashMapStorage<Key,Value> implements Storage<Key,Value>{
    HashMap<Key,Value> output ;
    int capacity;
    public HashMapStorage(int capacity ){
        this.output = new HashMap<>();
        this.capacity=capacity;
    }
    @Override
    public Value getValue(Key key){
        if(output.containsKey(key)){
            return output.get(key);
        }
        return null;
    }
    @Override
    public void addValue(Key key, Value value){
        output.put(key,value);
    }
    @Override
    public void removeKey(Key key){
        output.remove(key);
    }

    @Override
    public boolean isStorageFull() {
        if(output.size()==capacity){
            return true;
        }
        return false;
    }

    @Override
    public boolean ispresent(Key key) {
        return output.containsKey(key);
    }
}
