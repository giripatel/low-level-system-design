package Projects.ElevatorSystem.SchedulingStrategyPattern.ConcreteStrategies;

import Projects.ElevatorSystem.CommonEnums.Direction;
import Projects.ElevatorSystem.ElevatorRequestCommandPattern.ConcreteCommands.ElevatorRequest;
import Projects.ElevatorSystem.SchedulingStrategyPattern.SchedulingStrategy;
import Projects.ElevatorSystem.UtilityPackage.Elevator;

import java.util.PriorityQueue;
import java.util.Queue;

public class ScanSchedulingStrategy implements SchedulingStrategy {

    /**
     * @param elevator
     * @return
     */
    @Override
    public int getNextStop(Elevator elevator) {

        Direction elevatorDirection = elevator.getDirection();
        int currentFloor = elevator.getCurrentFloor();

        Queue<ElevatorRequest> requestQueue = elevator.getRequestQueue();

        PriorityQueue<ElevatorRequest> upQueue = new PriorityQueue<>();
        PriorityQueue<ElevatorRequest> downQueue = new PriorityQueue<>();

        while (!requestQueue.isEmpty()) {
            ElevatorRequest request = requestQueue.poll();

            if(request.getDirection() == Direction.UP) {
                upQueue.offer(request);
            } else if (request.getDirection() == Direction.DOWN) {
                downQueue.offer(request);
            }
        }

        if (!upQueue.isEmpty()) {

        }

        return 0;
    }
}
