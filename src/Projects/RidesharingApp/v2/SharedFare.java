package Projects.RidesharingApp.v2;

public class SharedFare implements FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKm() * distance * .50;
    }
}
