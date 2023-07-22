import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();
        bookMyShow.createBooking(City.Bangalore, "Bahubali");
        //user2
        bookMyShow.createBooking(City.Bangalore, "Bahubali");



    }
    private void createBooking(City userCity, String desiredMovie){
        //get movie object
        Movie movie = movieController.getMovieByName(desiredMovie);

        //get shows of this movie object
        List<Show> allShow = theatreController.getAllShow(userCity,movie);
        //taking hardcoded first show
        Show interestedShow = allShow.get(0);

        int seatNumber = 35;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();

        //check if this show is booked or not
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            //creating booking object here
            //finding out seat object from seat numbers and create a list of seats
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");

    }
    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }
    private void createMovies(){
        Movie movie1 = new Movie(1,"Bahubali",120);
        Movie movie2 = new Movie(2,"Avengers",125);

        movieController.addMovie(movie1,City.Mumbai);
        movieController.addMovie(movie2,City.Bangalore);

    }
    private void createTheatre(){
        //fetching movies
        Movie bahubali = movieController.getMovieByName("Bahubali");
        Movie avengers = movieController.getMovieByName("Avengers");

        //creating theatre
        Theatre inoxTheatre = new Theatre(1,City.Mumbai);
        Theatre pvrTheatre = new Theatre(1,City.Bangalore);

        //creating shows
        inoxTheatre.setScreens(createScreens());
        pvrTheatre.setScreens(createScreens());

        //creating shows
        inoxTheatre.setShows(createShows(inoxTheatre));
        pvrTheatre.setShows(createShows(pvrTheatre));

        theatreController.addTheatre(City.Mumbai,inoxTheatre);
        theatreController.addTheatre(City.Bangalore,pvrTheatre);

    }

    public List<Screen> createScreens(){
        Screen screen1 = new Screen(1,createSeats());
//        Screen screen2 = new Screen(2,createSeats());

        List<Screen>screens = new ArrayList<>();
        screens.add(screen1);
//        screens.add(screen2);
        return screens;

    }
    public List<Show>createShows(Theatre theatre){
        Show morningShow = new Show(1, movieController.getMovieByName("Avengers"), theatre.getScreens().get(0), 8);
        Show eveningShow = new Show(2, movieController.getMovieByName("Bahubali"), theatre.getScreens().get(0), 16);
        List<Show> shows = new ArrayList<>();
        shows.add(morningShow);
        shows.add(eveningShow);
        return shows;
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }



}