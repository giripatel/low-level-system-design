package Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses;

import Projects.ATM_Machine.ATMStatePattern.ATMMachineContext;
import Projects.ATM_Machine.ATMStatePattern.ATMState;

public class HasCardState implements ATMState {

    public HasCardState() {
        System.out.println("ATM in HasCardState please enter pin");
    }
    /**
     * @return 
     */
    @Override
    public String getStateName() {
        return "HasCardState";
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

        if (context.getCurrentAccount() != null) {
            return context.getStateFactory().createSelectOperationState();
        }

        return this;
    }
}
