package Projects.ATM_Machine.UtilityClasses;

import Projects.ATM_Machine.CommonEnums.CashType;

import java.util.HashMap;
import java.util.Map;

public class ATMInventory {
    Map<CashType, Integer> cashInventory;

    public ATMInventory() {
        this.cashInventory = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        cashInventory.put(CashType.BILL_100, 10);
        cashInventory.put(CashType.BILL_200, 10);
        cashInventory.put(CashType.BILL_500, 10);
    }

    private void addCash(CashType cashType,int amount) {
        cashInventory.put(cashType, cashInventory.getOrDefault(cashType, 0) + amount);
    }

    public int getTotalBalance() {
        int amount = 0;

        for (Map.Entry<CashType, Integer> entry: cashInventory.entrySet()) {
            int cashDenomination = entry.getKey().value;
            int number = entry.getValue();
            amount += cashDenomination * number;
        }
        return amount;
    }

    public boolean hasSufficientBalance(int amount) {
        if (getTotalBalance() >= amount) return true;
        return false;
    }

    public Map<CashType, Integer> dispenseCash(int amount) {
        if (!hasSufficientBalance(amount)) return null;
        Map<CashType, Integer> dispensedCash = new HashMap<>();
        int remainingAmount = amount;

        for (CashType cashType: CashType.values()) {
            int count = Math.min(remainingAmount / cashType.value, cashInventory.get(cashType));

            if (count > 0) {
                dispensedCash.put(cashType, count);
                remainingAmount = remainingAmount - cashType.value * count;
                cashInventory.put(cashType, cashInventory.get(cashType) - count);
            }
        }

        // if not able to dispense rollback the transaction
        if (remainingAmount > 0) {
            for (Map.Entry<CashType, Integer> entry: dispensedCash.entrySet()) {
                CashType key = entry.getKey();
                cashInventory.put(key, cashInventory.getOrDefault(key, 0) + entry.getValue());
            }
            return null;
        }

        return dispensedCash;
    }
}
