package Projects.LoggingSystem.CORPattern.ConcreteLogHandlers;

import Projects.LoggingSystem.CORPattern.LogHandler;
import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;

public class ErrorLogger extends LogHandler {

    public ErrorLogger(int level, LogAppender logAppender) {
        super(level, logAppender);
    }

    /**
     * @param message
     */
    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
