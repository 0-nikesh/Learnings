import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MatrixMultiplication {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors(); // Number of available processor cores

    public static int[][] multiply(int[][] A, int[][] B) {
        int numRowsA = A.length;
        int numColsA = A[0].length;
        int numColsB = B[0].length;

        if (numColsA != B.length) {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }

        int[][] result = new int[numRowsA][numColsB];
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Submit tasks to the executor
        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                executor.submit(new MultiplyTask(A, B, result, i, j));
            }
        }

        // Shutdown the executor
        executor.shutdown();

        try {
            // Wait for all tasks to complete
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Task for multiplying a single element of the result matrix
    static class MultiplyTask implements Runnable {
        private final int[][] A;
        private final int[][] B;
        private final int[][] result;
        private final int row;
        private final int col;

        public MultiplyTask(int[][] A, int[][] B, int[][] result, int row, int col) {
            this.A = A;
            this.B = B;
            this.result = result;
            this.row = row;
            this.col = col;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int k = 0; k < A[0].length; k++) {
                sum += A[row][k] * B[k][col];
            }
            result[row][col] = sum;
        }
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] B = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] result = multiply(A, B);

        // Print the result matrix
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
