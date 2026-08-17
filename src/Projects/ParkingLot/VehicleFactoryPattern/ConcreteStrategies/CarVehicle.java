package Projects.ParkingLot.VehicleFactoryPattern.ConcreteStrategies;

import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.VehicleFactoryPattern.Vehicle;

public class CarVehicle extends Vehicle {
    public CarVehicle(String licenseNumber, String vehicleType, ParkingFeeStrategy parkingFeeStrategy) {
        super(licenseNumber, vehicleType, parkingFeeStrategy);
    }
}
