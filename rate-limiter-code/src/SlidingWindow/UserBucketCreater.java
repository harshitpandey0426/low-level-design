package SlidingWindow;

import RateLimiter.LeakyBucket.LeakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreater {
    Map<Integer, SlidingWindow> bucket;
    UserBucketCreater(int id){
        bucket = new HashMap<>();
        bucket.put(id, new SlidingWindow(5, 1)); //hard coded capacity here
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){ // get this from redis now if we have kept queue in redis
//            processRequest(id);
            System.out.println(Thread.currentThread().getName() + " Access the application");
        }
        else{
            System.out.println("Error Status 429 too many requests");
        }
    }
//    void processRequest(int id){ //this can be called by application to process request and free space from queue
//        LeakyBucket leakyBucket = bucket.get(id);
//        leakyBucket.queue.poll();
//    }
}