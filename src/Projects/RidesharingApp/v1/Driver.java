package Projects.RidesharingApp.v1;

public class Driver {
    private String name;
    private Vehicle vehicle;
    private Location location;

    public Driver(String name, Location location, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
        this.location = location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation(){
        return  location;
    }

    public Vehicle getVechile(){
        return vehicle;
    }

    public String getName(){
        return name;
    }
}
