package RateLimiter.TokenBucket;

import RateLimiter.TokenBucket.TokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreater2 {
    Map<Integer,TokenBucket> bucket;
    UserBucketCreater2(int id){
        bucket = new HashMap<>();
        bucket.put(id, new TokenBucket(10,10)); //hard coded capacity here
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){ // get this from redis now if we have kept queue in redis
            System.out.println(Thread.currentThread().getName() + " Access the application");
        }
        else{
            System.out.println("Error Status 429 too many requests");
        }
    }
    void processRequest(int id){ //this can be called by application to process request and free space from queue
        TokenBucket tokenBucket = bucket.get(id);

    }
}

