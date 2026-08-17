package Projects.ParkingLot.VehicleFactoryPattern.ConcreteStrategies;

import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.VehicleFactoryPattern.Vehicle;

public class BikeVehicle extends Vehicle {
    public BikeVehicle(String licenseNumber, String vehicleType, ParkingFeeStrategy parkingFeeStrategy) {
        super(licenseNumber, vehicleType, parkingFeeStrategy);
    }
}
