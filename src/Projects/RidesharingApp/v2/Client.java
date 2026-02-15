package Projects.RidesharingApp.v2;

public class Client {
    public static void main(String[] args) {
        Location loc1 = new Location(12.9716, 77.5946);
        Location loc2 = new Location(12.9352, 77.6245);
        Location loc3 = new Location(13.0352, 77.6175);

        // Create Vehicles
        Vehicle car = new Car("AB123CD");
        Vehicle bike = new Bike("XY987Z");

        // Create Drivers
        Driver driver1 = new Driver("Alice", "driver1@gamil.com", loc2, car);
        Driver driver2 = new Driver("Bob", "diver2@gmail.com", loc3, car);

        Passenger passenger1 = new Passenger("John", "passenger1@gmail.com", loc1);
        Passenger passenger2 = new Passenger("Giri", "passenger2@gmail.com", loc3);

        RideMatchingService app = new RideMatchingService();

        app.addDriver(driver1);
        app.requestRide(passenger1, 10, new StandardFare());
//        app.addDriver(driver2);

//        app.bookRide(passenger1, 20);
//        app.bookRide(passenger2, 10);
    }
}
