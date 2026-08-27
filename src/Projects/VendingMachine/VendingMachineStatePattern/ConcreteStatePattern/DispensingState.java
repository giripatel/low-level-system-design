package Projects.VendingMachine.VendingMachineStatePattern.ConcreteStatePattern;

import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineContext;
import Projects.VendingMachine.VendingMachineStatePattern.VendingMachineState;

public class DispensingState implements VendingMachineState {

    public DispensingState(){
        System.out.println("Vending Machine is now in Dispense State");
    }
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
        return "DispenseState";
    }
}
