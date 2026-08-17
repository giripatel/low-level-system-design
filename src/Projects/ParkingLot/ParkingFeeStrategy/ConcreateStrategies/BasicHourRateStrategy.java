package Projects.ParkingLot.ParkingFeeStrategy.ConcreateStrategies;

import Projects.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Projects.ParkingLot.Utility.DurationType;

public class BasicHourRateStrategy implements ParkingFeeStrategy {

    public double calculateFee(String type, int duration, DurationType durationType) {

        switch (type.toLowerCase()) {
            case "car" ->{
                return durationType == DurationType.HOURS
                        ? duration * 10.0
                        : 10.0 * 24 * duration;
            }
            case "bike" -> {
                return durationType == DurationType.HOURS
                        ? duration * 5.0
                        : 5.0 * 24 * duration;
            }
            default -> {
                return durationType == DurationType.HOURS
                        ? duration * 15.0
                        : 15.0 * 24 * duration;
            }
        }
    }
}
