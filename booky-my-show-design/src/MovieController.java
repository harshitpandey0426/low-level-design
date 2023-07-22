import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMovieMap = new HashMap<>();
    List<Movie>allMovies = new ArrayList<>(); //for the case if someone just wants to search for movies

    //all crud operations
    public void addMovie(Movie movie, City city){
        allMovies.add(movie);
        List<Movie>allMoviesInCity = cityMovieMap.getOrDefault(city,new ArrayList<>());
        allMoviesInCity.add(movie);
        cityMovieMap.put(city,allMoviesInCity);
    }
    public Movie getMovieByName(String name){
        for(Movie movie : allMovies){
            if(movie.movieName.equals(name)){
                return movie;
            }
        }
        return null;
    }
    List<Movie> getMoviesByCity(City city) {
        return cityMovieMap.get(city);
    }

}
