package Projects.ParkingLot.ParkingController;

import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.ParkingSpots.ParkingSpot;
import Projects.ParkingLot.VehicleFactoryPattern.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingSpot> parkingSpots;

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot getAvailbleParkingSpot(Vehicle vehicle) {
        for (ParkingSpot parkingSpot: parkingSpots) {
            if (!parkingSpot.isOccupied() && parkingSpot.getSpotType() == vehicle.getVehicleType()) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = getAvailbleParkingSpot(vehicle);
        if (spot != null) {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle Parked successfully");
            return spot;
        }
        System.out.println("No spots are available");
        return null;
    }

    public void vacateVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
        if (!parkingSpot.isOccupied()) {
            throw new IllegalArgumentException("Parking spot is not occupied");
        }
        if(parkingSpot != null && parkingSpot.getVehicle() == vehicle) {
            parkingSpot.vacate();
            System.out.println("Vehicle vacated from spot");
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant "
                    + "or the vehicle does not match.");
        }
    }

    public ParkingSpot getParkingSpotByNumber(int spotNumber) {
        for (ParkingSpot spot: parkingSpots) {
            if(spotNumber == spot.getSpotNumber()) {
                return  spot;
            }
        }

        return null;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
