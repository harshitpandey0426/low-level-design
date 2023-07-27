package RateLimiter.TokenBucket;

import RateLimiter.TokenBucket.UserBucketCreater2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        UserBucketCreater2 userBucketCreater2 = new UserBucketCreater2(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i=0;i<=12;i++){
            executors.execute(() -> userBucketCreater2.accessApplication(1)); // to make each request in a parallel thread
//            userBucketCreater2.accessApplication(1);
        }
        executors.shutdown();
    }
}
