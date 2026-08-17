package Projects.ParkingLot.ParkingFeeStrategy;

import Projects.ParkingLot.Utility.DurationType;

public interface ParkingFeeStrategy {
    double calculateFee(String vehicleType, int duration, DurationType durationType);
}
