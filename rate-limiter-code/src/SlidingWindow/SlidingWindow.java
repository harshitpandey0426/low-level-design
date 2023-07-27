package SlidingWindow;

import RateLimiter.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter {
    private Long timeFrame;
    public Queue<Long>slidingWindow;
    private long bucketCapacity;
    public SlidingWindow(long capacity, long timeFrame){
        this.bucketCapacity=capacity;
        this.timeFrame = timeFrame;
        slidingWindow = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if(slidingWindow.size()<bucketCapacity){
            slidingWindow.offer(System.currentTimeMillis());
            return true;
        }
        return false;
    }
    void checkAndUpdateQueue(long currentTime){

        if(slidingWindow.isEmpty()){
            return;
        }
        long timeDiff = (currentTime - slidingWindow.peek())/1000;
        while(timeDiff >= timeFrame){
            slidingWindow.poll();
            if(slidingWindow.isEmpty()){
                break;
            }
            timeDiff = (currentTime - slidingWindow.peek())/1000;
        }


    }
}
