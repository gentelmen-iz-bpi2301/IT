package lab7;

public class ArraySumTask {
    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int sum1 = 0;
    private static int sum2 = 0;
    
    public static void main(String[] args){
        
        Thread thread1 = new Thread( () -> {
            for (int i = 0; i < array.length/2; i++) {
                sum1 += array[i];
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = array.length/2; i<array.length; i++){
                sum2 += array[i];
            }
        });
        try{
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        int sum = sum1 + sum2;
        System.out.println("Сумма элементов: "+sum);
        }

    
    }



