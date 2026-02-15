package Projects.RidesharingApp.v2;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingService {
    private List<Driver> availableDrivers;

    public RideMatchingService(){
        this.availableDrivers = new ArrayList<>();
    }

    public void addDriver(Driver availbleDriver){
        availableDrivers.add(availbleDriver);
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

        availableDrivers.remove(assignedDirver);
        return assignedDirver;
    }

    public void requestRide(Passenger passenger, double distance, FareStrategy fareStrategy) {

        if(availableDrivers.isEmpty()) {
            passenger.notify("Currently drivers are not available due to high demand");
            return;
        }

        Driver availableDriver = assignDriver(passenger, distance);

        Ride ride = new Ride(availableDriver, passenger, fareStrategy, distance);
        ride.calculateFare();

        passenger.notify("Your ride is booked for fare " + ride.getFare() +" with "+ availableDriver.name);
        availableDriver.notify("Your ride is booked for fare " + ride.getFare() +" with "+ passenger.name);

        // Ride status change to ONGOING
        ride.setRideStatus(RideStatus.ONGOING);

        // Ride status change to COMPLETE
        ride.setRideStatus(RideStatus.COMPLETED);

        availableDrivers.add(availableDriver);
    }
}
