package Projects.MovieBookingSystem.Controller;

import Projects.MovieBookingSystem.Service.MovieService;
import Projects.MovieBookingSystem.UtilityPackage.Movie;

public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public int createMove(String movieName, int durationInMinutes) {
        Movie newMovie = movieService.createMovie(movieName, durationInMinutes);
        return newMovie.getId();
    }
}
