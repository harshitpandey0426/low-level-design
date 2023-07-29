package Category;

import Category.AbstractLogger;
import Sink.LogSubject;

public class DebugLogger extends AbstractLogger {
    public DebugLogger(int level){
        super(level);
    }
    @Override
    protected void display(String msg, LogSubject loggerSubject) {

        loggerSubject.notifyAllObserver(1,"DEBUG : "+msg);
    }
}
