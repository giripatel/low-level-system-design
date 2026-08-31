package Projects.LoggingSystem.Variation1.Controllers;

import Projects.LoggingSystem.CommonEnums.LogLevel;
import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogConfig {
    private LogLevel logLevel;
    private LogAppender appender;

    public LogConfig(LogLevel logLevel, LogAppender logAppender) {
        this.logLevel = logLevel;
        this.appender = logAppender;
    }

    public LogAppender getAppender() {
        return appender;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setAppender(LogAppender appender) {
        this.appender = appender;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
