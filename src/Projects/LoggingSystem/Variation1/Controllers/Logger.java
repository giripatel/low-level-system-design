package Projects.LoggingSystem.Variation1.Controllers;

import Projects.LoggingSystem.CommonEnums.LogLevel;
import Projects.LoggingSystem.UtilityClasses.LogMessage;
import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Logger {
    private  static Logger instance;
    LogConfig logConfig;

    private Logger(LogLevel logLevel, LogAppender logAppender) {
        this.logConfig = new LogConfig(logLevel, logAppender);
    }

    public static Logger getInstance(LogLevel logLevel, LogAppender appender) {
        if (instance == null) {
            instance = new Logger(logLevel, appender);
        }
        return instance;
    }

    private void log(LogLevel level, String message) {
        if (level.getValue() >= logConfig.getLogLevel().getValue()) {
            LogMessage logMessage = new LogMessage(level, message, 403840384930840432l);
            logConfig.getAppender().append(logMessage);
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
