package Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern;

import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineContext;
import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineState;

public class IdleState implements VendingMachineState {
    /**
     * @param context
     * @return
     */
    @Override
    public VendingMachineState next(VendingMachineContext context) {
        return new HasMoneyState();
    }

    /**
     * @return 
     */
    @Override
    public String getStateName() {
        return "Idle State";
    }
}
