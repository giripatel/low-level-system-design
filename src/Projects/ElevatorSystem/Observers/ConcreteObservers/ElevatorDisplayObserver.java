package Projects.ElevatorSystem.Observers.ConcreteObservers;

import Projects.ElevatorSystem.CommonEnums.ElevatorState;
import Projects.ElevatorSystem.Observers.ElevatorObserver;
import Projects.ElevatorSystem.UtilityPackage.Elevator;

public class ElevatorDisplayObserver implements ElevatorObserver {
    /**
     * @param elevator
     * @param elevatorState
     */
    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState) {
        System.out.println("Elevator " + elevator.getId() + " State Changed to " + elevatorState);
    }

    /**
     * @param elevator
     * @param floor
     */
    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        System.out.println("Elevator " + elevator.getId() + " Floor changed to " + floor);
    }
}
