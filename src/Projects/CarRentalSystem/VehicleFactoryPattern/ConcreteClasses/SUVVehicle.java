package Projects.CarRentalSystem.VehicleFactoryPattern.ConcreteClasses;

import Projects.CarRentalSystem.CommonEnums.VehicleState;
import Projects.CarRentalSystem.CommonEnums.VehicleType;
import Projects.CarRentalSystem.Utility.Location;
import Projects.CarRentalSystem.VehicleFactoryPattern.Vehicle;

public class SUVVehicle extends Vehicle {
    private static final double RATE_MULTIPLIER = 1.5;
    public SUVVehicle(String registrationNumber, String model, VehicleType vehicleType, VehicleState vehicleState) {
        super(registrationNumber, model, vehicleType, vehicleState);
    }
}
