public abstract class AbstractLogger {
    int level; //current level -> means if level is 3 we will print all logs info error, debug
    AbstractLogger nextLevelLogger; //next level it hast to go to like we did for manager
    public AbstractLogger(int level){
        this.level = level;

    }

    public void setNextLevelLogger(AbstractLogger nextLevelLogger){
        this.nextLevelLogger = nextLevelLogger;
    }

    void logMessage(int level, String msg){
        if(this.level <= level ){
            display(msg);
        }
        if(nextLevelLogger!=null){
            nextLevelLogger.logMessage(level,msg);
        }
    }
    protected abstract void display(String msg);

}
