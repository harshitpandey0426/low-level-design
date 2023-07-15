import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Rider harshitRider = new Rider("Harshit",Rating.Medium);
        Rider abhinavRider = new Rider("Abhinav",Rating.High);
        Rider minkuRider = new Rider("Minku",Rating.Low);
        RiderManager riderManager = RiderManager.getInstanceOfRiderManager();
        riderManager.addRider(harshitRider,"1");
        riderManager.addRider(abhinavRider,"2");
        riderManager.addRider(minkuRider,"3");


        Driver jeetuDriver = new Driver("Jeetu",Rating.Medium);
        Driver rinkuDriver = new Driver("Rinku",Rating.Medium);
        DriverManager driverManager = DriverManager.getInstanceOfDriverManager();
        driverManager.addDriver(jeetuDriver,"1");
        driverManager.addDriver(rinkuDriver,"2");

        TripManager tripManager = TripManager.getTripManagerInstance();

        tripManager.createTrip(harshitRider,new Location(200,200),new Location(100,100));
        tripManager.createTrip(abhinavRider,new Location(213,222),new Location(35,32));


//        display all created trips

        HashMap<Integer, Trip>allTrips = tripManager.getTripsInfo();
        for(var trip: allTrips.entrySet()){
            System.out.println(trip.toString());
        }


    }
}