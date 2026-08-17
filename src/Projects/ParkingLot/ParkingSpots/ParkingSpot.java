package Projects.ParkingLot.ParkingSpots;

import Projects.ParkingLot.VehicleFactoryPattern.Vehicle;

public abstract class ParkingSpot {
    private boolean isOccupied;
    private int spotNumber;
    private Vehicle vehicle;
    private String spotType;

    public ParkingSpot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle) {
        if(isOccupied) {
            throw new  IllegalArgumentException("This spot is already occupied");
        }

        if (!canParkVehicle(vehicle)) {
            throw new  IllegalArgumentException("This spot is not suitable for : " + vehicle.getVehicleType());
        }

        this.vehicle = vehicle;
        isOccupied = true;
    }

    public void vacate() {
        if(!isOccupied) {
            throw new IllegalArgumentException("This spot is not occupied");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public String getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}