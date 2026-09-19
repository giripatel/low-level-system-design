package Projects.MovieBookingSystem.UtilityPackage;

import java.util.Date;

public class Show {
    int id;
    Movie movie;
    Screen screen;
    Date startTime;
    Integer durationInSeconds;

    public Show(int id, Movie movie, Screen screen, Date startTime, Integer durationInSeconds) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInSeconds = durationInSeconds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getStartTime() {
        return startTime;
    }
}
