public class LogManager {

    static AbstractLogger buildChainOfLogger(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(debugLogger);

        return infoLogger; //lowest most is returned because if something is not logged as info it will be tried to log to next level
    }
}
