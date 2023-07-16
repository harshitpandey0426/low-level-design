import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RiderMgr {
    private static RiderMgr riderMgrInstance;
    private static Lock mtx = new ReentrantLock();
    private Map<String, Rider> ridersMap;

    private RiderMgr() {
        ridersMap = new HashMap<>();
    }

    public static RiderMgr getRiderMgr() {
        if (riderMgrInstance == null) {
            mtx.lock();
            if (riderMgrInstance == null) {
                riderMgrInstance = new RiderMgr();
            }
            mtx.unlock();
        }
        return riderMgrInstance;
    }

    public void addRider(String riderName, Rider rider) {
        ridersMap.put(riderName, rider);
    }

    public Rider getRider(String riderName) {
        return ridersMap.get(riderName);
    }
}
