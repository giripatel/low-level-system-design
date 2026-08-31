package Projects.LoggingSystem.Variation1.AppenderStrategies;

import Projects.LoggingSystem.UtilityClasses.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
