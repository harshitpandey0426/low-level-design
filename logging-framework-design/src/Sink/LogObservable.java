package Sink;

import java.util.ArrayList;
import java.util.List;

public interface LogObservable {

    void addObserver(int level, LogObserver logObserver);
    void removeObserver(LogObserver logObserver);
    void notifyAllObserver(int level, String message);
}
