import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CompletableFutureDemo {
    public static void main(String[] args) {
        // Task 1: Simulate fetching data asynchronously
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate fetching data from a remote server
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data from Task 1";
        });

        // Task 2: Simulate processing data asynchronously
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate processing data
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data from Task 2";
        });

        // Combine the results of both tasks when they are completed
        CompletableFuture<Void> combinedTask = task1.thenCombine(task2, (result1, result2) -> {
            // Perform some operation with the results
            String combinedResult = result1 + " and " + result2;
            System.out.println("Combined Result: " + combinedResult);
            return null;
        });

        // Wait for the completion of both tasks
        try {
            combinedTask.get(); // Wait until both tasks are completed
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
