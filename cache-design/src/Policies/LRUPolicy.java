package Policies;


import Storage.HashMapStorage;

import java.util.*;

public class LRUPolicy<Key,Value> implements EvictionPolicy<Key,Value>{
   LinkedList<Key> dll;
    HashMap<Key,Integer> keyVsValue;
   int capacity;
   public LRUPolicy(){
       dll = new LinkedList<>();
       keyVsValue = new HashMap<>();
   }
    @Override
   public void keyAccessed(Key key){
       if(keyVsValue.containsKey(key)){
           dll.remove(key);
       }
       dll.addLast(key);
        keyVsValue.put(key,1);
   }
    @Override
    public Key evictKey(){
       if(dll.getFirst()==null){
           return null;
       }
       Key key = dll.getFirst();
       dll.removeFirst();
       keyVsValue.remove(key);
       return key;
   }

}
