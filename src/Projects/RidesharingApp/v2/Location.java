package Projects.RidesharingApp.v2;

public class Location {

    private double longitude;
    private double latitude;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private double calcDistance(Location to) {
        double dx = this.getLatitude() - to.getLatitude();
        double dy = this.getLongitude() - to.getLongitude();
        return Math.sqrt((dx * dx)  + (dy * dy));
    }

}