package Projects.LoggingSystem.CORPattern.ConcreteLogHandlers;

import Projects.LoggingSystem.CORPattern.LogHandler;
import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;

public class InfoLogger extends LogHandler {

    public InfoLogger(int level, LogAppender appender) {
        super(level, appender);
    }
    /**
     * @param message
     */
    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}
