package Projects.RidesharingApp.v1;

import java.util.ArrayList;
import java.util.List;

/*
    - The RideSharingAppService violates the SRP Principle by handling multiple things.
    - 1. Managing Drivers
    - 2. Managing Passengers
    - 3. Driver matching
    - 4. booking
    - 5. calculations

    ***
    The vechile class violates OCP, we could have modulized the Vechile types.
 */
public class RideSharingAppService {
    private List<Driver> drivers;
    private List<Passenger> passengers;

    public RideSharingAppService() {
        this.drivers = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDriver(Driver driver){
        drivers.add(driver);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    private double calculateFare(Vehicle vehicle, double distance) {

        // Violates LSP Principle
        // Violates ISP Principle
        if(vehicle.getType().equals("Car")){
            return distance * 20;
        } else if (vehicle.getType().equals("Bike")) {
            return distance *  10;
        } else {
            return distance * 8;
        }
    }

    private double calcDistance(Location passangerLocation, Location driverLocation) {
        double latitudeDistance = passangerLocation.getLatitude() - driverLocation.getLatitude();
        double longitudeDistance = passangerLocation.getLongitude() - driverLocation.getLongitude();
        double totalDistance = (latitudeDistance * latitudeDistance) + (longitudeDistance * longitudeDistance);
        return Math.sqrt(totalDistance);
    }

    public void bookRide(Passenger passenger, double distance) {

        if(drivers.isEmpty()) {
            System.out.println("Divers not available at the moment");
            return;
        }

        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver: drivers) {

            double calDistance = calcDistance(passenger.getLocation(), driver.getLocation());
            if(calDistance < minDistance) {
                assignedDriver = driver;
                minDistance = calDistance;
            }
        }

        double calculatedFare = calculateFare(assignedDriver.getVechile(), distance);
        System.out.println(assignedDriver.getName() + " is assigned to : " + passenger.getName());
    }
}
