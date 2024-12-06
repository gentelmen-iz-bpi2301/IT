public class MatrixMaxTask {
    private static final int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    private static int[] results;

    public static void main(String[] args) throws InterruptedException {
        int rows = matrix.length;
        results = new int[rows];
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++) {
            final int rowIndex = i;
            threads[i] = new Thread(() -> {
                int maxInRow = Integer.MIN_VALUE;
                for (int value : matrix[rowIndex]) {
                    if (value > maxInRow) {
                        maxInRow = value;
                    }
                }
                results[rowIndex] = maxInRow;
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int overallMax = Integer.MIN_VALUE;
        for (int max : results) {
            if (max > overallMax) {
                overallMax = max;
            }
        }

        System.out.println("Наибольший элемент в матрице: " + overallMax);
    }
    
}
