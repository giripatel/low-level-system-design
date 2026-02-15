package Projects.RidesharingApp.v2;

public class Ride {
    private Driver driver;
    private Passenger passenger;
    private double distance;
    private FareStrategy fareStrategy;
    private double fare;
    private RideStatus rideStatus;

    public Ride(Driver driver, Passenger passenger, FareStrategy fareStrategy, double distance) {
        this.driver = driver;
        this.passenger = passenger;
        this.fareStrategy = fareStrategy;
        this.distance = distance;
        this.rideStatus = RideStatus.SCHEDULED;
    }

    public void calculateFare() {
        this.fare = fareStrategy.calcFare(driver.getVehicle(), distance);
    }

    public double getFare(){
        return this.fare;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
        notifyUsers(rideStatus);
    }

    public void notifyUsers(RideStatus rideStatus){
        passenger.notify("Ride Status : " + rideStatus);
        driver.notify("Ride Status : " + rideStatus);

    }
}
