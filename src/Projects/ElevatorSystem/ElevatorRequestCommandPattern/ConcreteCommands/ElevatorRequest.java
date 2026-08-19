package Projects.ElevatorSystem.ElevatorRequestCommandPattern.ConcreteCommands;

import Projects.ElevatorSystem.CommonEnums.Direction;
import Projects.ElevatorSystem.Controller.ElevatorController;

public class ElevatorRequest {
    private int requestedFloor;
    private int elevatorId;
    private Direction direction;
    private ElevatorController controller;
    private boolean isInternalRequest;

    public ElevatorRequest(int requestedFloor, int elevatorId, boolean isInternalRequest, Direction direction) {
        this.requestedFloor = requestedFloor;
        this.elevatorId = elevatorId;
        this.isInternalRequest = isInternalRequest;
        this.direction = direction;
    }

    public void execute() {

    }

    public int getElevatorId() {
        return elevatorId;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isInternalRequest() {
        return isInternalRequest;
    }

    public int getFloor() {
        return requestedFloor;
    }
}

