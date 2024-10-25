package lab4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String firstFile = "IT/lab/lab4/file1.txt";
        String secondFile = "IT/lab/lab4/file2.txt";

        try (FileInputStream inputStream = new FileInputStream(firstFile); FileOutputStream outputStream = new FileOutputStream(secondFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                //inputStream.close();
            }


            System.out.println("Копирование завершено успешно!");

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами");
        }
    }
}