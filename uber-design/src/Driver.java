public class Driver {
    private String name;
    private boolean avail;
    private Rating rating;

    public Driver(String name, Rating rating) {
        this.name = name;
        this.rating = rating;
        this.avail = false;
    }

    public void updateAvail(boolean avail) {
        this.avail = avail;
    }

    public String getDriverName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }
}
