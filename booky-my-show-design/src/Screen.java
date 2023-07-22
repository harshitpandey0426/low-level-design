import java.util.ArrayList;
import java.util.List;

public class Screen {
    int screenNumber;
    List<Seat> seats = new ArrayList<>();

    public Screen(int screenNumber, List<Seat> seats) {
        this.screenNumber = screenNumber;
        this.seats=seats;
    }

    //getters and setters
    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }


    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
