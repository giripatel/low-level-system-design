package Projects.CarRentalSystem.Utility;

import Projects.CarRentalSystem.CommonEnums.VehicleState;
import Projects.CarRentalSystem.VehicleFactoryPattern.Vehicle;

import java.util.*;

public class RentalStore {
    int id;
    String name;
    Location location;
    Map<String, Vehicle> vehicles;

    public RentalStore(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        vehicles = new HashMap<>();
    }

    public void  addVehicle(String registrationNumber, Vehicle vehicle) {
        if (vehicles.containsKey(registrationNumber)) {
            System.out.println("Vehicle already exists");
        }
        vehicles.put(registrationNumber, vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        if (!vehicles.containsKey(registrationNumber)) {
            System.out.println("Vehicle not in the store");
        }
        vehicles.remove(registrationNumber);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle: vehicles.values()) {
            if (vehicle.getVehicleState() == VehicleState.AVAILABLE) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public Vehicle getVehicle(String registrationNumber) {
        if (!vehicles.containsKey(registrationNumber)) {
            System.out.println("Vehicle not in the store");
        }
        return vehicles.get(registrationNumber);
    }

    public boolean isVehicleAvailable(String registrationNumber, Date startDate, Date endDate) {
        return true;
    }

    public int getId() {
        return id;
    }
}
