package Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses;

import Projects.ATM_Machine.ATMStatePattern.ATMMachineContext;
import Projects.ATM_Machine.ATMStatePattern.ATMState;

public class SelectOperationState implements ATMState {

    public SelectOperationState() {
        System.out.println("ATM is in Select Operation State - Please select an operation");
        System.out.println("1. Withdraw cash");
        System.out.println("2. Check balance");
    }

    @Override
    public String getStateName() {
        return "SelectOperationState";
    }

    /**
     * @param context
     * @return
     */
    @Override
    public ATMState nextState(ATMMachineContext context) {
        if (context.getCurrentCard() == null) {
            return context.getStateFactory().createIdleState();
        }
        if (context.getCurrentSelectedOperation() != null) {
            return context.getStateFactory().createTransactionState();
        }
        return this;
    }
}
