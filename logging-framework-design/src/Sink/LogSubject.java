package Sink;

import Sink.LogObservable;
import Sink.LogObserver;

import java.util.*;

public class LogSubject implements LogObservable {
    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();
    @Override
    public void addObserver(int level, LogObserver logObserver) {
        List<LogObserver> currentLogger = logObservers.getOrDefault(level, new ArrayList<>());
        currentLogger.add(logObserver);
        this.logObservers.put(level, currentLogger);
    }

    @Override
    public void removeObserver(LogObserver logObserver) {
        for( Map.Entry<Integer, List<LogObserver>> entry : logObservers.entrySet()){
            entry.getValue().remove(logObserver);
        }
    }

    @Override
    public void notifyAllObserver(int level, String message) {
        List <LogObserver> allObservers = logObservers.get(level);
        for(LogObserver observers : allObservers){
            observers.log(message);
        }
//        for( Map.Entry<Integer, List<LogObserver>> logObserver : logObservers.entrySet()){
//            if (logObserver.getKey() == level){
//                logObserver.getValue().forEach(observer -> observer.log(message));
//            }
//        }
    }
}
