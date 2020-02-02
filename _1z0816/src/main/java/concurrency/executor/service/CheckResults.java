package concurrency.executor.service;

import java.util.concurrent.*;
public class CheckResults {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // single thread.
            Future<?> result = service.submit(() -> {
                for(int i=0; i<500; i++) CheckResults.counter++;
            });
            result.get(10, TimeUnit.SECONDS); // during the time of 10 if available return.
            System.out.println("Reached!");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}