package Projects.ParkingLot.ParkingSpots.ConcretePakringSpots;

import Projects.ParkingLot.ParkingSpots.ParkingSpot;
import Projects.ParkingLot.VehicleFactoryPattern.ConcreteStrategies.BikeVehicle;
import Projects.ParkingLot.VehicleFactoryPattern.Vehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    /**
     * @param vehicle 
     * @return
     */
    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        if (vehicle instanceof BikeVehicle) {
            return true;
        }
        return false;
    }


}
