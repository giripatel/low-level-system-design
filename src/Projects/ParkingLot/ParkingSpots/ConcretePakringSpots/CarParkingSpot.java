package Projects.ParkingLot.ParkingSpots.ConcretePakringSpots;

import Projects.ParkingLot.ParkingSpots.ParkingSpot;
import Projects.ParkingLot.VehicleFactoryPattern.ConcreteStrategies.CarVehicle;
import Projects.ParkingLot.VehicleFactoryPattern.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    /**
     * @param vehicle 
     * @return
     */
    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        if (vehicle instanceof CarVehicle) {
            return true;
        }
        return false;
    }
}
