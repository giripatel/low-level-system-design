package Projects.VendingMachine.VendingMachineStatePattern;

import Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern.IdleState;

public class VendingMachineContext {
    VendingMachineState vendingMachineState;

    public VendingMachineContext() {
        this.vendingMachineState = new IdleState();
    }

    public VendingMachineState getCurrentState() {
        return vendingMachineState;
    }

    public void advanceNext() {
        VendingMachineState state = vendingMachineState.next(this);
        this.vendingMachineState = state;
    }
}
