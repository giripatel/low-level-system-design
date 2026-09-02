package Projects.Splitwise.SplitStrategyPattern.ConcreteSplitStrategy;

import Projects.Splitwise.SplitStrategyPattern.Split;
import Projects.Splitwise.UtilityClasses.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements Split {

    /**
     * @return splits
     */
    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participants, Map<String, Object> splitDetails) {
        double amountPerPerson = amount / participants.size(); // Divide the amount equally among all participants
        Map<User, Double> splits = new  HashMap<>();

        for (User user: participants) {
            splits.put(user, amountPerPerson);
        }

        return splits;
    }
}
