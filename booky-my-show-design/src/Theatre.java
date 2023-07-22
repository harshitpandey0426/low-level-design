import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int theatreId;
    City city;
    List<Screen> screens = new ArrayList<>();
    List<Show>shows = new ArrayList<>();

    public Theatre(int theatreId, City city) {
        this.theatreId = theatreId;
        this.city = city;
    }
    //getters and setters


    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public City getLocation() {
        return city;
    }

    public void setLocation(City city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
