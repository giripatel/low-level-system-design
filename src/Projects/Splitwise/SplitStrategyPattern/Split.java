package Projects.Splitwise.SplitStrategyPattern;

import Projects.Splitwise.UtilityClasses.User;

import java.util.List;
import java.util.Map;

public interface Split {
    Map<User, Double> calculateSplit(double d, List<User> ds, Map<String, Object> dkljff);
}
