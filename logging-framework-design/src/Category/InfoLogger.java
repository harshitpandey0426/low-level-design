package Category;

import Category.AbstractLogger;
import Sink.LogSubject;

public class InfoLogger extends AbstractLogger {
    public InfoLogger(int level){
        super(level);
    }
    @Override
    protected void display(String msg, LogSubject loggerSubject) {

        loggerSubject.notifyAllObserver(1,"INFO : "+msg);
    }
}
