public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance;
    private static Object mtx = new Object();

    private StrategyMgr() {}

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null) {
            synchronized (mtx) {
                if (strategyMgrInstance == null) {
                    strategyMgrInstance = new StrategyMgr();
                }
            }
        }
        return strategyMgrInstance;
    }

    public PricingStrategy determinePricingStrategy(TripMetaData metaData) {
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new DefaultPricingStrategy();
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData metaData) {
        System.out.println("Based on location and other factors, setting matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }
}
