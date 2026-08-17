package Projects.ParkingLot.VehicleFactoryPattern;

import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.Utility.DurationType;

public abstract class Vehicle {
    private String licenseNumber;
    private String vehicleType;
    private ParkingFeeStrategy parkingFeeStrategy;

    public Vehicle(String licenseNumber, String vehicleType, ParkingFeeStrategy parkingFeeStrategy) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double calculateFee(int duration, DurationType durationType) {
        return parkingFeeStrategy.calculateFee(vehicleType, duration, durationType);
    }
}
