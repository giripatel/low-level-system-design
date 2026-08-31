package Projects.LoggingSystem;

import Projects.LoggingSystem.CORPattern.ConcreteLogHandlers.DebugLogger;
import Projects.LoggingSystem.CORPattern.ConcreteLogHandlers.ErrorLogger;
import Projects.LoggingSystem.CORPattern.ConcreteLogHandlers.InfoLogger;
import Projects.LoggingSystem.CORPattern.LogHandler;
import Projects.LoggingSystem.CommonEnums.LogLevel;
import Projects.LoggingSystem.Variation1.AppenderStrategies.ConcreteAppenders.ConsoleAppender;
import Projects.LoggingSystem.Variation1.AppenderStrategies.ConcreteAppenders.FileAppender;
import Projects.LoggingSystem.Variation1.AppenderStrategies.LogAppender;
import Projects.LoggingSystem.Variation1.Controllers.Logger;

public class Main {

    private static LogHandler getCORLoggers(LogAppender appender) {
        LogHandler infoLogger = new InfoLogger(1, appender);
        LogHandler debugLogger = new DebugLogger(2, appender);
        LogHandler errorLogger = new ErrorLogger(3, appender);
        infoLogger.setNextLogHandler(debugLogger);
        debugLogger.setNextLogHandler(errorLogger);
        return infoLogger;
    }

    public static void main(String[] args) {
//        Logger logger = Logger.getInstance(LogLevel.ERROR, new FileAppender());
//
//        logger.debug("hello world");
//        logger.error("hello world");

        LogHandler loggerChain = getCORLoggers(new FileAppender());

        System.out.println("Logging INFO level message: ");
        loggerChain.logMessage(LogHandler.INFO, "This is an information");
        System.out.println("Logging DEBUG level message: ");
        loggerChain.logMessage(LogHandler.DEBUG, "This is a debug level information");
        System.out.println("Logging ERROR level message");
        loggerChain.logMessage(LogHandler.ERROR, "This is an error information");


    }
}
