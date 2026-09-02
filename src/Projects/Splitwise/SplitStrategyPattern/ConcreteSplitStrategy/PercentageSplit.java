package Projects.Splitwise.SplitStrategyPattern.ConcreteSplitStrategy;

import Projects.Splitwise.SplitStrategyPattern.Split;
import Projects.Splitwise.UtilityClasses.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplit implements Split {

    /**
     * @return
     */
    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participants, Map<String, Object> splitDetails) {

        Map<User, Double> percentages = (Map<User, Double>) splitDetails.get("percentages");
        Map<User, Double> splits = new HashMap<>();

        for (User user: participants) {
            double percentage = percentages.getOrDefault(user, 0.0);
            splits.put(user, amount * percentage / 100.0);
        }

        return splits;
    }
}
