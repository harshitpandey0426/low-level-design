package RateLimiter.TokenBucket;
import RateLimiter.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {
    private int bucketCapacity;
    private int refreshRate;
    private AtomicInteger currentCapacity; // to make it thread safe
    private AtomicLong lastUpdatedTime;
    public TokenBucket(int bucketCapacity, int refreshRate){
        this.bucketCapacity=bucketCapacity;
        this.refreshRate=refreshRate;
        currentCapacity= new AtomicInteger(bucketCapacity);
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
    }
    @Override
    public boolean grantAccess() {

        if(currentCapacity.get()>0){
            currentCapacity.getAndDecrement();
            return true;
        }
        return false;

    }
    public void refreshBucket(){
        long currentTime = System.currentTimeMillis();
        long additionalToken = ((currentTime - lastUpdatedTime.get())/1000)*refreshRate;
        int currCapacity = (int)Math.min(currentCapacity.get()+additionalToken,bucketCapacity);
        currentCapacity.getAndSet(currCapacity);
        lastUpdatedTime.getAndSet(currentTime);
    }
}
