package Projects.LoggingSystem.CORPattern;

import Projects.LoggingSystem.CommonEnums.LogLevel;
import Projects.LoggingSystem.UtilityClasses.LogMessage;
import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;

public abstract class LogHandler {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    int level;
    LogHandler nextLogHandler;
    LogAppender logAppender;

    public LogHandler(int level, LogAppender logAppender) {
        this.level = level;
        this.logAppender = logAppender;
    }

    public void setNextLogHandler(LogHandler logHandler) {
        this.nextLogHandler = nextLogHandler;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            LogLevel logLevel = intToLogLevel(level);
            LogMessage logMessage = new LogMessage(logLevel, message, 409384309849l);
            if (logAppender != null) {
                logAppender.append(logMessage);
            }
            write(message);
        } else if (nextLogHandler != null) {
            nextLogHandler.logMessage(level, message);
        }
    }

    public LogLevel intToLogLevel(int level) {
        switch (level) {
            case 1: return LogLevel.INFO;
            case 2: return LogLevel.DEBUG;
            case 3: return LogLevel.ERROR;
            default: return null;
        }
    }

    protected abstract void write(String message);
}
