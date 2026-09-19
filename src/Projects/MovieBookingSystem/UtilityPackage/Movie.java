package Projects.MovieBookingSystem.UtilityPackage;

public class Movie {
    int id;
    String name;
    int duration;

    public Movie(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
