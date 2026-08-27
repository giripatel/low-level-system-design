package Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern;

import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineContext;
import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineState;

public class OutOfStockState implements VendingMachineState {
    /**
     * @param context
     * @return
     */
    @Override
    public VendingMachineState next(VendingMachineContext context) {
        return new IdleState();
    }

    /**
     * @return
     */
    @Override
    public String getStateName() {
        return "OutOfStockState";
    }
}
