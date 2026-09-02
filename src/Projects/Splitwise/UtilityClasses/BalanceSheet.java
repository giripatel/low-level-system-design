package Projects.Splitwise.UtilityClasses;

import Projects.Splitwise.ExpenseObserver.ExpenseObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet implements ExpenseObserver {
    private Map<UserPair, Double> balances = new HashMap<>();

    public void onExpenseAdded(Expense expense) {
        updatedBalances(expense);
    }

    public void onExpenseUpdated(Expense expense) {
        updatedBalances(expense);
    }

    private void updatedBalances(Expense expense) {
       User payer = expense.getPayer();
       Map<User, Double> shares = expense.getShares();
       for (Map.Entry<User, Double> entry: shares.entrySet()) {
           User participant = entry.getKey();
           double amount = entry.getValue();

           if(!participant.equals(payer)) {
               UserPair userPair = new UserPair(participant, payer);
               double currentBalance = balances.getOrDefault(userPair, 0.0);
               balances.put(userPair, currentBalance + amount);
           }
       }
    }

    public double getBalance(User user1, User user2) {

        UserPair userPair1 = new UserPair(user1, user2);
        UserPair userPair2 = new UserPair(user2, user1);

        double balance1 = balances.getOrDefault(userPair1, 0.0);
        double balance2 = balances.getOrDefault(userPair2, 0.0);
        return balance1 - balance2;
    }

    public double getTotalBalance(User user) {
        double total = 0.0;
        for (Map.Entry<UserPair, Double> entry: balances.entrySet()) {
            UserPair userPair = entry.getKey();
            double amount = entry.getValue();
            if (userPair.getUser1().equals(user)) {
                total -= amount; // User owns someone
            } else if (userPair.getUser2().equals(user)) {
                total += amount; // User gets money from someone
            }
        }

        return total;
    }

    public List<Transaction> getSimplifiedSettlements() {

        List<Transaction> transactions = new ArrayList<>();
        Map<User, Double> netBalance = new HashMap<>();
        //1. Create net balances
        for (Map.Entry<UserPair, Double> entry: balances.entrySet()) {
            User debtor = entry.getKey().getUser1();
            User creditor = entry.getKey().getUser2();

            double amount = entry.getValue();

            netBalance.put(debtor, netBalance.getOrDefault(debtor, 0.0) - amount);
            netBalance.put(creditor, netBalance.getOrDefault(creditor, 0.0) + amount);
        }

        //2. Separate debtors and creditors
        List<User> debtors = new ArrayList<>();
        List<User> creditors = new ArrayList<>();

        for (Map.Entry<User, Double> entry: netBalance.entrySet()) {
            User user = entry.getKey();
            double balance = entry.getValue();
            if (balance < 0) {
                debtors.add(user);
            } else {
                creditors.add(user);
            }
        }

        // 3. Create transactions
        int debtorsIndex = 0;
        int creditorsIndex = 0;

        while (debtorsIndex < debtors.size() && creditorsIndex < creditors.size()) {

            User debtor = debtors.get(debtorsIndex);
            User creditor = creditors.get(creditorsIndex);
            double debtorBalance = netBalance.get(debtor);
            double creditorBalance = netBalance.get(creditor);

            double transactionAmount = Math.min(Math.abs(debtorBalance), creditorBalance);

            Transaction transaction = new Transaction(debtors.get(debtorsIndex), creditors.get(creditorsIndex), transactionAmount);
            netBalance.put(debtor, netBalance.getOrDefault(debtor, 0.0) + transactionAmount);
            netBalance.put(creditor, netBalance.getOrDefault(creditor, 0.0) - transactionAmount);

            if (netBalance.get(debtor) == 0.0) {
                debtorsIndex ++;
            }

            if (netBalance.get(creditor) == 0.0) {
                creditorsIndex ++;
            }
        }

        return transactions;
    }

    public int getSubOptimalMinimumSettlements() {

        Map<User, Double> netBalances = new HashMap<>();
        for (Map.Entry<UserPair, Double> entry : balances.entrySet()) {
            UserPair pair = entry.getKey();
            double amount = entry.getValue();
            User debtor = pair.getUser1(); // The user who owes money
            User creditor = pair.getUser2(); // The user who is owed money

            // Update the net balance of each user
            netBalances.put(debtor, netBalances.getOrDefault(debtor, 0.0) - amount);
            netBalances.put(creditor, netBalances.getOrDefault(creditor, 0.0) + amount);
        }

        List<Double> creditList = new ArrayList<>();

        for (Map.Entry<User, Double> entry: netBalances.entrySet()) {
            if (entry.getValue() > 0) {
                creditList.add(entry.getValue());
            }
        }
        int n = creditList.size();
        return subOptimalDfs(0, creditList, n);
    }

    private int subOptimalDfs(int currentUserIndex, List<Double> creditList, int n) {

        while (currentUserIndex < n && creditList.get(currentUserIndex) == 0) {
            currentUserIndex ++;
        }

        if(currentUserIndex == 0) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;

        for (int nextIndex = currentUserIndex + 1; nextIndex < n; nextIndex ++) {
            if (creditList.get(nextIndex) * creditList.get(currentUserIndex) < 0) {
                creditList.set(nextIndex, creditList.get(nextIndex) + creditList.get(currentUserIndex));

                cost = Math.min(cost, 1 + subOptimalDfs(currentUserIndex + 1, creditList, n));

                creditList.set(nextIndex, creditList.get(nextIndex) - creditList.get(currentUserIndex));
            }
        }

        return cost;
    }

    public int getOptimalMinimumSettlements() {
        return 1;
    }

    private double sumOfMask(List<Double> d, int s) {
        return 0.0;
    }
}
