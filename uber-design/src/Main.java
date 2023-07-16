import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // ---------------Creating Riders and Drivers--------------------------------
        Rider keertiRider = new Rider("harshit", Rating.FIVE_STARS);
        Rider gauravRider = new Rider("abhinav", Rating.FIVE_STARS);
        RiderMgr riderMgr = RiderMgr.getRiderMgr();
        riderMgr.addRider("harshit", keertiRider);
        riderMgr.addRider("abhinav", gauravRider);

        Driver yogitaDriver = new Driver("minku", Rating.THREE_STARS);
        Driver riddhiDriver = new Driver("jeetu", Rating.FOUR_STARS);
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        driverMgr.addDriver("minku", yogitaDriver);
        driverMgr.addDriver("jeetu", riddhiDriver);

        // These details in turn will be stored in a database
        // -------------------------------------------------------------------------

        TripMgr tripMgr = TripMgr.getTripMgr();

        System.out.println("\nCreating Trip for harshit from location (10,10) to (30,30)");
        tripMgr.createTrip(keertiRider, new Location(10, 10), new Location(30, 30));

        System.out.println("\nCreating Trip for abhinav from location (200,200) to (500,500)");
        tripMgr.createTrip(gauravRider, new Location(200, 200), new Location(500, 500));

        // -------------------Display all the trips created--------------------------
        HashMap<Integer, Trip> tripsMap = tripMgr.getTripsMap();
        for (Map.Entry<Integer, Trip> entry : tripsMap.entrySet()) {
            entry.getValue().displayTripDetails();
        }
    }
}
