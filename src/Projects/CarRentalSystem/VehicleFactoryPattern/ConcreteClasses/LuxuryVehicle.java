package Projects.CarRentalSystem.VehicleFactoryPattern.ConcreteClasses;

import Projects.CarRentalSystem.CommonEnums.VehicleState;
import Projects.CarRentalSystem.CommonEnums.VehicleType;
import Projects.CarRentalSystem.Utility.Location;
import Projects.CarRentalSystem.VehicleFactoryPattern.Vehicle;

public class LuxuryVehicle extends Vehicle {
    private static final double RATE_MULTIPLIER = 2.5;
    private static final double PREMIUM_FEE = 50.0;

    public LuxuryVehicle(String registrationNumber, String model, VehicleType vehicleType, VehicleState vehicleState) {
        super(registrationNumber, model, vehicleType, vehicleState);
    }
}
