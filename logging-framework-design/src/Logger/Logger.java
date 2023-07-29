package Logger;

import Category.AbstractLogger;
import Sink.LogSubject;

public class Logger {
    private static Logger logger;
    private static AbstractLogger chainOfLogger;
    private volatile static LogSubject loggerSubject;
    private Logger(){

    }
    public static Logger getLoggerInstance(){
        LogManager logManager = new LogManager();
        if(logger==null){
            logger = new Logger();
            chainOfLogger = logManager.buildChainOfLogger();
            loggerSubject = logManager.addObservers();
        }
        return logger;
    }

    public void info(String message) {
        createLog(1, message);
    }

    public void error(String message) {
        createLog(2, message);
    }

    public void debug(String message) {
        createLog(3, message);
    }

    private void createLog(int level, String message){
        chainOfLogger.logMessage(level, message, loggerSubject);
    }

}
