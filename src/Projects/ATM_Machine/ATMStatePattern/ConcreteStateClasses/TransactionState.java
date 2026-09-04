package Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses;

import Projects.ATM_Machine.ATMStatePattern.ATMMachineContext;
import Projects.ATM_Machine.ATMStatePattern.ATMState;

public class TransactionState implements ATMState {

    public TransactionState() {
        System.out.println("ATM is in Transaction State");
    }

    /**
     * @return
     */
    @Override
    public String getStateName() {
        return "";
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
            return context.getStateFactory().createSelectOperationState();
        }

        return this;
    }
}
