import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DriverMgr {
    private static DriverMgr driverMgrInstance;
    private static Lock mtx = new ReentrantLock();
    private Map<String, Driver> driversMap;

    private DriverMgr() {
        driversMap = new HashMap<>();
    }

    public static DriverMgr getDriverMgr() {
        if (driverMgrInstance == null) {
            mtx.lock();
            if (driverMgrInstance == null) {
                driverMgrInstance = new DriverMgr();
            }
            mtx.unlock();
        }
        return driverMgrInstance;
    }

    public void addDriver(String driverName, Driver driver) {
        driversMap.put(driverName, driver);
    }

    public Driver getDriver(String driverName) {
        return driversMap.get(driverName);
    }

    public Map<String, Driver> getDriversMap() {
        return driversMap;
    }
}
