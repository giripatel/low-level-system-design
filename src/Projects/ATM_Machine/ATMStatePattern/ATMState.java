package Projects.ATM_Machine.ATMStatePattern;

public interface ATMState {
    String getStateName();
    ATMState nextState(ATMMachineContext context);
}
