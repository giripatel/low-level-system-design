package Projects.LoggingSystem.UtilityClasses;

import Projects.LoggingSystem.CommonEnums.LogLevel;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LogMessage {
    LogLevel level;
    String message;
    long timestamp;

    public LogMessage(LogLevel level, String message, long timestamp) {
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
    }
}
