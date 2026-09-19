package Projects.MovieBookingSystem.Service;

import Projects.MovieBookingSystem.UtilityPackage.Movie;
import Projects.MovieBookingSystem.UtilityPackage.Screen;
import Projects.MovieBookingSystem.UtilityPackage.Show;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ShowService {
    Map<Integer, Show> shows;
    AtomicInteger showCounter;

    public ShowService() {
        this.shows = new HashMap<>();
        this.showCounter = new AtomicInteger(0);
    }

    public Show getShow(Integer id) throws Exception {
        if (!shows.containsKey(id)) {
            throw new Exception("Show with ID " + id + " not found.");
        }
        return shows.get(id);
    }

    public Show createShow(Movie movie, Screen screen, Date startTime, Integer durationInSeconds) {
        int showId = showCounter.incrementAndGet();
        Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        shows.put(showId, show);
        return show;
    }

    public List<Show> getShowsForScreen(Screen screen) {
        List<Show> response = new ArrayList<>();
        for (Show show: shows.values()) {
            if (show.getScreen() == screen) {
                response.add(show);
            }
        }
        return response;
    }
}
