package Projects.RidesharingApp.v1;

public class Passenger {
    private String name;
    private Location location;

    public Passenger(String name, Location location){
        this.name = name;
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }
    public String getName(){
        return name;
    }
}
