package Projects.VendingMachine.VendingMachineStatePattern;

public interface VendingMachineState {
    VendingMachineState next(VendingMachineContext context);
    String getStateName();
}
