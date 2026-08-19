package Projects.ElevatorSystem.UtilityPackage;

import Projects.ElevatorSystem.CommonEnums.Direction;
import Projects.ElevatorSystem.CommonEnums.ElevatorState;
import Projects.ElevatorSystem.ElevatorRequestCommandPattern.ConcreteCommands.ElevatorRequest;
import Projects.ElevatorSystem.Observers.ElevatorObserver;

import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    ElevatorState elevatorState;
    List<ElevatorObserver> observers;
    Queue<ElevatorRequest> requests;

    public Elevator(int id) {
        this.id = id;
    }

    public void addObservers(ElevatorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ElevatorObserver observer) {
        observers.remove(observer);
    }

    private void notifyStateChange() {
        for (ElevatorObserver observer: observers) {
            observer.onElevatorStateChange(this, elevatorState);
        }
    }

    private void notifyFloorChange() {
        for (ElevatorObserver observer: observers) {
            observer.onElevatorFloorChange(this, currentFloor);
        }
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
        notifyStateChange();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addRequest(ElevatorRequest request) {
        requests.add(request);
    }

    public void moveToNextStop() {

    }

    private void completeArrival() {

    }

    public int getId() {
        return id;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public List<ElevatorObserver> getObservers() {
        return observers;
    }

    public Queue<ElevatorRequest> getRequestQueue() {
        return requests;
    }
}
