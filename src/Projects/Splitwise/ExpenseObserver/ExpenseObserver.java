package Projects.Splitwise.ExpenseObserver;

import Projects.Splitwise.UtilityClasses.Expense;

public interface ExpenseObserver {
    void onExpenseAdded(Expense expense);
    void onExpenseUpdated(Expense expense);
}
