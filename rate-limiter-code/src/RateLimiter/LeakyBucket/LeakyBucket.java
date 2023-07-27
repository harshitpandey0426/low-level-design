package RateLimiter.LeakyBucket;

import RateLimiter.RateLimiter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class LeakyBucket implements RateLimiter {
    BlockingQueue <Integer> queue; // keep this in redis for distributed env for global access
    public LeakyBucket(int capacity){
        this.queue = new LinkedBlockingDeque<>(capacity);
    }
    @Override
    public boolean grantAccess() {
        if(queue.remainingCapacity()>0){
            queue.add(1); // for simplicity, we have taken that per method call there will be only one request
            return true;
        }
        return false;
    }
}
