package Logger;

import Category.AbstractLogger;
import Category.DebugLogger;
import Category.ErrorLogger;
import Category.InfoLogger;
import Sink.ConsoleLogger;
import Sink.FileLogger;
import Sink.LogSubject;

public class LogManager {

    static AbstractLogger buildChainOfLogger(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(debugLogger);

        return infoLogger; //lowest most is returned because if something is not logged as info it will be tried to log to next level
    }
    static LogSubject addObservers(){
        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        logSubject.addObserver(1,consoleLogger);
        logSubject.addObserver(2,consoleLogger);
        logSubject.addObserver(3,consoleLogger);

        FileLogger fileLogger = new FileLogger();
        logSubject.addObserver(2,fileLogger);

        return logSubject;
    }
}
