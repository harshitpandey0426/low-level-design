import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> locationVsTheatre;
    List<Theatre> allTheatre;

    public TheatreController(Map<City, List<Theatre>> locationVsTheatre, List<Theatre> allTheatre) {
        this.locationVsTheatre = locationVsTheatre;
        this.allTheatre = allTheatre;
    }
    public void addTheatre(City city, Theatre theatre){
        allTheatre.add(theatre);
        List<Theatre> allTheatreInCity = locationVsTheatre.get(city);
        allTheatreInCity.add(theatre);
        locationVsTheatre.put(city,allTheatreInCity);
    }
    public List<Show> getAllShow(City city, Movie movie){
        List<Theatre> allTheatreInCity = locationVsTheatre.get(city);
        List<Show>allRequiredShow = new ArrayList<>();
        for(Theatre theatre:allTheatreInCity){
            List<Show>shows = theatre.getShows();
            for(Show show:shows){
                if(show.movie.movieId == movie.movieId){
                    allRequiredShow.add(show);
                }
            }
        }
        return allRequiredShow;
    }

}
