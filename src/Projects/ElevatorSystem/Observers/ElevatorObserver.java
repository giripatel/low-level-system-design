package Projects.ElevatorSystem.Observers;

import Projects.ElevatorSystem.CommonEnums.ElevatorState;
import Projects.ElevatorSystem.UtilityPackage.Elevator;

public interface ElevatorObserver {
    void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState);
    void onElevatorFloorChange(Elevator elevator, int floor);
}
