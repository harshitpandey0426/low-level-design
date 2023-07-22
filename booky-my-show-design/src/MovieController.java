import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> locationMovieMap = new HashMap<>();
    List<Movie>allMovies = new ArrayList<>(); //for the case if someone just wants to search for movies

    //all crud operations
    public void addMovie(Movie movie, City city){
        allMovies.add(movie);
        List<Movie>allMoviesInCity = locationMovieMap.get(city);
        allMoviesInCity.add(movie);
        locationMovieMap.put(city,allMoviesInCity);
    }
    public void getMovie(){

    }
}
