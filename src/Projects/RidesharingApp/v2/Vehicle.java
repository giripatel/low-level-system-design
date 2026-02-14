package Projects.RidesharingApp.v2;

abstract class Vehicle {
    protected String numberPlate;

    public Vehicle(String numberPlate){
        this.numberPlate = numberPlate;
    }

    public abstract double getFarePerKm();
}
