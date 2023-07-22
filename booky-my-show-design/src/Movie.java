public class Movie {
    int movieId;
    String movieName;
//    Address address;
    int durationInMinutes;

    public Movie(int movieId, String movieName, int durationInMinutes) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
    }
    //getters and setters


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
