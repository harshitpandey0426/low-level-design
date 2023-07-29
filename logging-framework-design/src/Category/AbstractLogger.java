package Category;

import Sink.LogSubject;

public abstract class AbstractLogger {
    int level; //current level -> means if level is 3 we will print all level logs (info error, debug)
    private AbstractLogger nextLevelLogger; //next level it hast to go to like we did for manager in design pattern
    public AbstractLogger(int level){
        this.level = level;
    }
    public void setNextLevelLogger(AbstractLogger nextLevelLogger){
        this.nextLevelLogger = nextLevelLogger;
    }
    public void logMessage(int level, String msg, LogSubject loggerSubject){
        if(this.level==level){
            display(msg, loggerSubject);
        }

        if (nextLevelLogger!=null) {
            nextLevelLogger.logMessage(level, msg, loggerSubject);
        }
    }
    protected abstract void display(String msg, LogSubject loggerSubject);

}
