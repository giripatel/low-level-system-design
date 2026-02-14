package Projects.RidesharingApp.v1;

public class Vehicle {
    public String numberPlate;
    public String type;

    public Vehicle(String numberPlate, String type) {
        this.numberPlate = numberPlate;
        this.type = type;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getType() {
        return type;
    }
}
