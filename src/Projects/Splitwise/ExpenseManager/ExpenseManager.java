package Projects.Splitwise.ExpenseManager;

import Projects.Splitwise.ExpenseObserver.ExpenseObserver;
import Projects.Splitwise.UtilityClasses.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<ExpenseObserver> observers;
    private List<Expense> expenses;

    public ExpenseManager() {
        this.observers = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
    public void addObserver(ExpenseObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ExpenseObserver observer) {
        observers.remove(observer);
    }

    private void notifyExpenseAdded(Expense expense) {
        for (ExpenseObserver expenseObserver: observers) {
            expenseObserver.onExpenseAdded(expense);
        }
    }

    private void notifyExpenseUpdated(Expense expense) {
        for (ExpenseObserver expenseObserver: observers) {
            expenseObserver.onExpenseUpdated(expense);
        }
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
        notifyExpenseAdded(expense);
    }

    public void updateExpense(Expense expense) {
        this.expenses.remove(expense);
        this.expenses.add(expense);
        notifyExpenseUpdated(expense);
    }

    public List<Expense> getAllExpense() {
        return expenses;
    }
}
