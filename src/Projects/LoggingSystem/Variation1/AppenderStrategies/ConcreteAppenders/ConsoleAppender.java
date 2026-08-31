package Projects.LoggingSystem.Variation1.AppenderStrategies.ConcreteAppenders;

import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;
import Projects.LoggingSystem.UtilityClasses.LogMessage;

public class ConsoleAppender implements LogAppender {

    /**
     * @param message
     */
    @Override
    public void append(LogMessage message) {
        System.out.println("From Console Appender: " + message);
    }
}
