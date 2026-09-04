package Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses;

import Projects.ATM_Machine.ATMStatePattern.ATMMachineContext;
import Projects.ATM_Machine.ATMStatePattern.ATMState;

public class IdleState implements ATMState {

    public IdleState() {
        System.out.println("ATM is int Idle State, Please insert card");
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
        if (context.getCurrentCard() != null) {
            return context.getStateFactory().createHashCardState();
        }
        return this;
    }
}
