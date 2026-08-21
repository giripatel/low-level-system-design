package Projects.CarRentalSystem.VehicleFactoryPattern;

import Projects.CarRentalSystem.CommonEnums.VehicleState;
import Projects.CarRentalSystem.CommonEnums.VehicleType;
import Projects.CarRentalSystem.Utility.Location;
import Projects.CarRentalSystem.VehicleFactoryPattern.ConcreteClasses.LuxuryVehicle;
import Projects.CarRentalSystem.VehicleFactoryPattern.ConcreteClasses.SUVVehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String registrationNumber, String model, VehicleType vehicleType, VehicleState vehicleState) {
        switch (vehicleType) {
            case SUV: return new SUVVehicle(registrationNumber, model, vehicleType, vehicleState);
            case LUXURY: return new LuxuryVehicle(registrationNumber, model, vehicleType, vehicleState);
            default: throw new IllegalArgumentException();
        }
    }
}
