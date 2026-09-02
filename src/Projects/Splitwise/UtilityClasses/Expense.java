package Projects.Splitwise.UtilityClasses;

import java.util.List;
import java.util.Map;

public class Expense {

    private String id;
    private double amount;
    private String description;
    private User payer;
    private List<User> participants;
    private Map<User, Double> shares;

    public Expense(String id, String description, double amount, User payer, List<User> participants, Map<User, Double> shares) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.payer = payer;
        this.participants = participants;
        this.shares = shares;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public Map<User, Double> getShares() {
        return shares;
    }

    public String getDescription() {
        return description;
    }

    public User getPayer() {
        return payer;
    }
}
