package RateLimiter.LeakyBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        RateLimiter.LeakyBucket.UserBucketCreater userBucketCreater = new RateLimiter.LeakyBucket.UserBucketCreater(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i=0;i<=12;i++){
            executors.execute(() -> userBucketCreater.accessApplication(1)); // to make each request in a parallel thread
//            userBucketCreater.accessApplication(1);
        }
        executors.shutdown();
    }
}