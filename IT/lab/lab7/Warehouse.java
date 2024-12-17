import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Warehouse {
    private static final int MAX_WEIGHT = 150;
    private static final int NUM_WORKERS = 3;
    private static Semaphore semaphore = new Semaphore(NUM_WORKERS);
    private static List<Integer> warehouse = new ArrayList<>();
    private static int currentWeight = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            warehouse.add((int) (Math.random() * 100));

        }
        for (int i = 0; i < NUM_WORKERS; i++) {
            new Thread(new Worker(i + 1)).start();
        }
    }

    static class Worker implements Runnable {
        private int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    semaphore.acquire();
                    Integer itemWeight;
                    synchronized (lock) {
                        if (warehouse.isEmpty()) {
                            System.out.println("Грузчик - " + id + " закончил работу.");
                            semaphore.release();
                            break;
                        }

                        itemWeight = warehouse.remove(0);
                        if (currentWeight + itemWeight > MAX_WEIGHT) {
                            System.out.println("Грузчик - " + id + " переносит товар на другой склад, потому что набрал максимальный вес.");
                            goodsTransfer();
                        }

                        currentWeight += itemWeight;
                        System.out.println("Грузчик - " + id + " добавил товар весом: " + itemWeight + ". Текущий вес: " + currentWeight);
                    }

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.err.println("Поток был прерван: "+e);
                } finally {
                    semaphore.release();
                }
            }
        }
        private void goodsTransfer() {
            synchronized (lock) {
                System.out.println("---Переносим товар на другой склад весом: " + currentWeight + "---");
                currentWeight = 0;
            }
        }

    }
}
