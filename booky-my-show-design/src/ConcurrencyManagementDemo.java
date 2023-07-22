import java.util.concurrent.atomic.AtomicInteger;
//In this code, we have a simple Record class with data and version fields. The update method attempts to update the data field and increments the version before updating. The two threads are updating the record concurrently, and we use AtomicInteger to manage the version number safely in a multi-threaded environment.
//
//        Please note that the Thread.sleep calls in the code simulate some processing time to illustrate the possibility of concurrent updates. In a real application, the updates may be triggered by different events or conditions.
class Record {
    private String data;
    private AtomicInteger version;

    public Record(String data) {
        this.data = data;
        this.version = new AtomicInteger(0);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getVersion() {
        return version.get();
    }

    public void update(String newData) {
        // Increment the version number before updating the data
        int currentVersion = version.get();
        int newVersion = currentVersion + 1;

        // Simulate some processing time before updating
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Update the data and the version number
        this.data = newData;
        this.version.set(newVersion);
    }
}

public class ConcurrencyManagementDemo {
    public static void main(String[] args) {
        Record record = new Record("Initial Data");

        // Two threads updating the record concurrently
        Thread thread1 = new Thread(() -> {
            // Read the data and version
            String data = record.getData();
            int version = record.getVersion();

            // Perform some processing before updating
            // Simulating some delay here
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Attempt to update the record
            // If the version has changed, it means another thread has updated the record, so the update fails
            record.update(data + " - Thread 1 Update");
        });

        Thread thread2 = new Thread(() -> {
            // Read the data and version
            String data = record.getData();
            int version = record.getVersion();

            // Perform some processing before updating
            // Simulating some delay here
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Attempt to update the record
            // If the version has changed, it means another thread has updated the record, so the update fails
            record.update(data + " - Thread 2 Update");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final data and version of the record
        System.out.println("Final Data: " + record.getData());
        System.out.println("Final Version: " + record.getVersion());
    }
}
