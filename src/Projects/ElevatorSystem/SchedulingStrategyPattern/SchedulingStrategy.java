package Projects.ElevatorSystem.SchedulingStrategyPattern;

import Projects.ElevatorSystem.UtilityPackage.Elevator;

public interface SchedulingStrategy {
    int getNextStop(Elevator elevator);
}
