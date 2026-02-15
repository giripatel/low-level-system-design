package Projects.RidesharingApp.v2;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingService {
    private List<Driver> availableDrivers;

    public RideMatchingService(){
        this.availableDrivers = new ArrayList<>();
    }

    public Driver assignDriver(Passenger passenger, double distance) {
        Driver assignedDirver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver: availableDrivers) {
            double passengerToDiverDistance = driver.getLocation().calcDistance(passenger.getLocation());
            if (minDistance > passengerToDiverDistance) {
                assignedDirver = driver;
                minDistance = passengerToDiverDistance;
            }
        }
        return assignedDirver;
    }
    public void bookRide(Passenger passenger, double distance, FareStrategy fareStrategy) {

        if(availableDrivers.size() < 1) {
            passenger.notify("Currently drivers are not available due to high demand");
            return;
        }

        Driver availableDriver = assignDriver(passenger, distance);
//        availableDriver.notify("");

    }
}
