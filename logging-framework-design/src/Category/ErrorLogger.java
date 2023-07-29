package Category;

import Category.AbstractLogger;
import Sink.LogSubject;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        super(level);
    }
    @Override
    protected void display(String msg, LogSubject loggerSubject) {
        loggerSubject.notifyAllObserver(2,"ERROR : "+msg);
    }
}
