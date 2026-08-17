package Projects.ParkingLot.ParkingFeeStrategy.ConcreateStrategies;

import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.Utility.DurationType;

public class PremiumRateStrategy implements ParkingFeeStrategy {
    /**
     * @param vehicleType 
     * @param duration
     * @param durationType
     * @return
     */
    @Override
    public double calculateFee(String vehicleType, int duration, DurationType durationType) {
        switch (vehicleType.toLowerCase()) {
            case "car" ->{
                return durationType == DurationType.HOURS
                        ? duration * 15.0
                        : 15.0 * 24 * duration;
            }
            case "bike" -> {
                return durationType == DurationType.HOURS
                        ? duration * 10.0
                        : 10.0 * 24 * duration;
            }
            default -> {
                return durationType == DurationType.HOURS
                        ? duration * 20.0
                        : 20.0 * 24 * duration;
            }
        }
    }
}
