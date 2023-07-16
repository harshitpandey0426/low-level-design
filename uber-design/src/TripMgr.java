import java.util.HashMap;

public class TripMgr {
    private static TripMgr tripMgrInstance;
    private static Object mtx = new Object();
    private HashMap<Integer, Trip> tripsInfo;
    private HashMap<Integer, TripMetaData> tripsMetaDataInfo;

    private TripMgr() {
        tripsInfo = new HashMap<>();
        tripsMetaDataInfo = new HashMap<>();
    }

    public static TripMgr getTripMgr() {
        if (tripMgrInstance == null) {
            synchronized (mtx) {
                if (tripMgrInstance == null) {
                    tripMgrInstance = new TripMgr();
                }
            }
        }
        return tripMgrInstance;
    }

    public void createTrip(Rider pRider, Location pSrcLoc, Location pDstLoc) {
        TripMetaData metaData = new TripMetaData(pSrcLoc, pDstLoc, pRider.getRating());
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();

        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(metaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineMatchingStrategy(metaData);
        PricingStrategy pricingStrategy1 = new DefaultPricingStrategy();

        //created context class for calculation ---- ------- ------- -------
        DriverMatchingStrategy driverMatchingStrategy1 = new LeastTimeBasedMatchingStrategy();
        Context context = new Context(pricingStrategy1,driverMatchingStrategy1,metaData);
        Driver driver1 = context.matchDriver(metaData);
        double tripPrice1 = context.calculatePrice(metaData);

        Driver driver = driverMatchingStrategy.matchDriver(metaData);
        double tripPrice = pricingStrategy.calculatePrice(metaData);


        Trip trip = new Trip(pRider, driver, pSrcLoc, pDstLoc, tripPrice, pricingStrategy, driverMatchingStrategy);
        int tripId = trip.getTripId();
        tripsInfo.put(tripId, trip);
        tripsMetaDataInfo.put(tripId, metaData);
    }

    public HashMap<Integer, Trip> getTripsMap() {
        return tripsInfo;
    }
}
