import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadArraySum{
    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(() -> {
            int sum = 0;
            for (int i = 0; i < array.length / 2; i++) {
                sum += array[i];
            }
            return sum;
        });

        Future<Integer> future2 = executor.submit(() -> {
            int sum = 0;
            for (int i = array.length / 2; i < array.length; i++) {
                sum += array[i];
            }
            return sum;
        });
        int totalSum = 0;
        try{
            int sum1 = future1.get();
            int sum2 = future2.get();
            totalSum = sum1 + sum2;
        }
        catch (InterruptedException e){
            System.err.println("Поток был прерван: "+e);
        }
        catch (ExecutionException e){
            System.out.println(e);
        }
        finally{
            executor.shutdown();
        }
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}