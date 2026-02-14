package Projects.RidesharingApp.v2;

public class LuxuryFare implements FareStrategy {

    @Override
    public double calcFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKm() * distance * 1.50;
    }
}
