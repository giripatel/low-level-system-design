package Projects.Splitwise.SplitFactoryPattern;

import Projects.Splitwise.SplitStrategyPattern.ConcreteSplitStrategy.EqualSplit;
import Projects.Splitwise.SplitStrategyPattern.ConcreteSplitStrategy.PercentageSplit;
import Projects.Splitwise.SplitStrategyPattern.Split;

public class SplitFactory {
    public static Split createSplit(String split) {

        if (split.equals("EQUAL")) {
            return new EqualSplit();
        } else {
            return new PercentageSplit();
        }
    }
}
