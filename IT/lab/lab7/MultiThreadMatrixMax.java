import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadMatrixMax {
    private static final int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(matrix.length);
        @SuppressWarnings("unchecked")
        Future<Integer>[] futures = new Future[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            final int rowIndex = i;
            futures[i] = executor.submit(() -> {
                int maxInRow = Integer.MIN_VALUE;
                for (int value : matrix[rowIndex]) {
                    if (value > maxInRow) {
                        maxInRow = value;
                    }
                }
                return maxInRow;
            });
        }

        int overallMax = Integer.MIN_VALUE;
        try{
            for (Future<Integer> future : futures) {
                overallMax = Math.max(overallMax, future.get());
            }
        }
        catch (ExecutionException e){
            System.err.println(e);
        }

        catch (InterruptedException e){
            System.err.println(e);
        }
        
        finally{
            executor.shutdown();
        }
        System.out.println("Наибольший элемент в матрице: " + overallMax);
    }
}
