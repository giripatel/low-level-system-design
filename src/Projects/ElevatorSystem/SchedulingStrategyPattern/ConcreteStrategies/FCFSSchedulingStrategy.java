package Projects.ElevatorSystem.SchedulingStrategyPattern.ConcreteStrategies;

import Projects.ElevatorSystem.CommonEnums.Direction;
import Projects.ElevatorSystem.ElevatorRequestCommandPattern.ConcreteCommands.ElevatorRequest;
import Projects.ElevatorSystem.SchedulingStrategyPattern.SchedulingStrategy;
import Projects.ElevatorSystem.UtilityPackage.Elevator;

import java.util.Queue;

public class FCFSSchedulingStrategy implements SchedulingStrategy {
    /**
     * @param elevator 
     * @return
     */
    @Override
    public int getNextStop(Elevator elevator) {
        Direction direction = elevator.getDirection();
        int currentFloor = elevator.getCurrentFloor();

        Queue<ElevatorRequest> requestQueue = elevator.getRequestQueue();
        if(requestQueue.isEmpty()) {
            return  currentFloor;
        }

        int nextRequestedFloor = requestQueue.poll().getFloor();

        if (nextRequestedFloor == currentFloor) {
            return currentFloor;
        } else if (direction == Direction.IDLE) {
            elevator.setDirection(currentFloor > nextRequestedFloor
            ? Direction.DOWN : Direction.UP);
        } else if (direction == Direction.UP && nextRequestedFloor < currentFloor) {
            elevator.setDirection(Direction.DOWN);
        } else if(nextRequestedFloor > currentFloor) {
            elevator.setDirection(Direction.UP);
        }

        return nextRequestedFloor;
    }
}
