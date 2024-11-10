import java.util.regex.*;

public class NumFind {
    public static void main(String[] args) {
        String text = "Скидка 50% на всю одежду! Успейте забрать топовый худи за 2399.00";

        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");

        Matcher matcher = pattern.matcher(text);

        try {
            boolean found = false;
            while (matcher.find()) {
                System.out.println("Найдено число: " + matcher.group());
                found = true;
            }
            if (!found) {
                System.out.println("Числа не найдены.");
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}