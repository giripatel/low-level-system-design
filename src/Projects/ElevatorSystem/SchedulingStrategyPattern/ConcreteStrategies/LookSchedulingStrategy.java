package Projects.ElevatorSystem.SchedulingStrategyPattern.ConcreteStrategies;

import Projects.ElevatorSystem.SchedulingStrategyPattern.SchedulingStrategy;
import Projects.ElevatorSystem.UtilityPackage.Elevator;

public class LookSchedulingStrategy implements SchedulingStrategy {
    /**
     * @param elevator 
     * @return
     */
    @Override
    public int getNextStop(Elevator elevator) {
        return 0;
    }
}
