package Projects.ParkingLot.VehicleFactoryPattern;

import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.VehicleFactoryPattern.ConcreteStrategies.BikeVehicle;
import Projects.ParkingLot.VehicleFactoryPattern.ConcreteStrategies.CarVehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String licensePlate, ParkingFeeStrategy parkingFeeStrategy) {
        if (vehicleType.toLowerCase().equals("car")) {
            return new CarVehicle(licensePlate, vehicleType, parkingFeeStrategy);
        }
        return new BikeVehicle(licensePlate, vehicleType, parkingFeeStrategy);
    }
}
