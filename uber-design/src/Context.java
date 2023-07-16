public class Context {
    PricingStrategy pricingStrategy;
    DriverMatchingStrategy driverMatchingStrategy;
    TripMetaData tripMetaData;

     Context(PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy, TripMetaData tripMetaData){
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy=driverMatchingStrategy;
        this.tripMetaData=tripMetaData;
    }
    public double calculatePrice(TripMetaData tripMetaData){
        return pricingStrategy.calculatePrice(tripMetaData);
    }
    public Driver matchDriver(TripMetaData tripMetaData){
        return driverMatchingStrategy.matchDriver(tripMetaData);
    }
}

