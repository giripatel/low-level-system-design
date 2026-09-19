package Projects.MovieBookingSystem.Controller;

import Projects.MovieBookingSystem.Service.MovieService;
import Projects.MovieBookingSystem.Service.SeatAvailabilityService;
import Projects.MovieBookingSystem.Service.ShowService;
import Projects.MovieBookingSystem.Service.TheatreService;
import Projects.MovieBookingSystem.UtilityPackage.Movie;
import Projects.MovieBookingSystem.UtilityPackage.Screen;
import Projects.MovieBookingSystem.UtilityPackage.Seat;
import Projects.MovieBookingSystem.UtilityPackage.Show;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowController {
    private SeatAvailabilityService seatAvailabilityService;
    private ShowService showService;
    private TheatreService theatreService;
    private MovieService movieService;

    public ShowController(SeatAvailabilityService seatAvailabilityService, ShowService showService, TheatreService theatreService, MovieService movieService) {
        this.seatAvailabilityService = seatAvailabilityService;
        this.showService = showService;
        this.theatreService = theatreService;
        this.movieService = movieService;
    }

    public int createShow(int movieId, int screenId, Date startTime, Integer durationInSeconds) throws Exception {
        Movie movie = movieService.getMovie(movieId);
        Screen screen = theatreService.getScreen(screenId);
        Show show = showService.createShow(movie, screen, startTime, durationInSeconds);
        return show.getId();
    }

    public List<Integer> getAvailableSeats(int showId) throws Exception {
        Show show = showService.getShow(showId);
        List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);

        List<Integer> seatIds = new ArrayList<>();

        for (Seat seat: availableSeats) {
            seatIds.add(seat.getId());
        }
        return seatIds;
    }
}
