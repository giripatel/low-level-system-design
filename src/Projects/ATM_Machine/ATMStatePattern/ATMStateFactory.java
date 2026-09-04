package Projects.ATM_Machine.ATMStatePattern;

import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.HasCardState;
import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.IdleState;
import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.SelectOperationState;
import Projects.ATM_Machine.ATMStatePattern.ConcreteStateClasses.TransactionState;

public class ATMStateFactory {

    private static ATMStateFactory instance;

    public static ATMStateFactory getInstance() {
        if (instance == null) {
            instance = new ATMStateFactory();
        }
        return instance;
    }

    public ATMState createIdleState(){
        return new IdleState();
    }

    public ATMState createHashCardState() {
        return new HasCardState();
    }

    public ATMState createSelectOperationState() {
        return new SelectOperationState();
    }

    public ATMState createTransactionState() {
        return new TransactionState();
    }
}
