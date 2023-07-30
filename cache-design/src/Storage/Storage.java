package Storage;

public interface Storage <Key,Value>{
    Value getValue(Key key);
    void addValue(Key key, Value value);
    void removeKey(Key key);
    boolean isStorageFull();
    boolean ispresent(Key key);

}
