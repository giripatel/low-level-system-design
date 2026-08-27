package Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern;

import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineContext;
import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineState;

public class HasMoneyState implements VendingMachineState {
    /**
     * @param context
     * @return
     */
    @Override
    public VendingMachineState next(VendingMachineContext context) {
//        if(context.getCurrentState() instanceof HasMoneyState) {
//            return new SelectionState();
//        }

        return new SelectionState();
    }

    /**
     * @return 
     */
    @Override
    public String getStateName() {
        return "HasMoneyState";
    }
}
