package Projects.CarRentalSystem.VehicleFactoryPattern;


import Projects.CarRentalSystem.CommonEnums.VehicleState;
import Projects.CarRentalSystem.CommonEnums.VehicleType;
import Projects.CarRentalSystem.Utility.Location;

public abstract class Vehicle {
    String registrationNumber;
    String model;
    VehicleType vehicleType;
    VehicleState vehicleState;
    double basePrice;

    public Vehicle(String registrationNumber, String model, VehicleType vehicleType, VehicleState vehicleState) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.vehicleState = vehicleState;
        this.vehicleType = vehicleType;
    }

    public double calculateRentalFare(int days) {
        return days * basePrice;
    }

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getBasePrice() {
        return basePrice;
    }


    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}
