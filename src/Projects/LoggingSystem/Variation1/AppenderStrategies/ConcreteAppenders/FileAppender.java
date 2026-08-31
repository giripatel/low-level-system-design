package Projects.LoggingSystem.Variation1.AppenderStrategies.ConcreteAppenders;

import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;
import Projects.LoggingSystem.UtilityClasses.LogMessage;

public class FileAppender implements LogAppender {
    /**
     * @param message
     */
    @Override
    public void append(LogMessage message) {
        System.out.println("From FileAppender : " + message);
    }
}
