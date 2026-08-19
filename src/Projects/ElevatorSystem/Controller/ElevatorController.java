package Projects.ElevatorSystem.Controller;

import Projects.ElevatorSystem.CommonEnums.Direction;
import Projects.ElevatorSystem.SchedulingStrategyPattern.SchedulingStrategy;
import Projects.ElevatorSystem.UtilityPackage.Elevator;
import Projects.ElevatorSystem.UtilityPackage.Floor;

import java.util.List;

public class ElevatorController {
    List<Elevator> elevators;
    List<Floor> floors;
    SchedulingStrategy strategy;
    int currentElevatorId;

    public ElevatorController(int numberOfElevators, int numberOfFloors) {

    }

    public void setSchedulingStrategy(SchedulingStrategy strategy) {
        this.strategy = strategy;
    }

    public void requestElevator(int elevatorId, int floor, Direction direction) {

    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public int getCurrentElevatorId() {
        return currentElevatorId;
    }

    public void setCurrentElevator(int currentElevatorId) {
        this.currentElevatorId = currentElevatorId;
    }

//    public Elevator getElevatorById(int elevatorId) {
//
//    }

    public void step() {

    }
}
