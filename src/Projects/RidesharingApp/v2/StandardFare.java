package Projects.RidesharingApp.v2;

public class StandardFare implements FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKm() * distance;
    }
}
