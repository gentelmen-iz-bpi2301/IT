import java.util.ArrayList;
import java.util.List;

public class tasks3 {
    public static void main (String[] args) {
        List<String[]> products = new ArrayList<>();
        products.add(new String[]{"Laptop", "124200"});
        products.add(new String[]{"Phone", "51450"});
        products.add(new String[]{"Laptop", "13800"});
        double discount = 0.25;
        List<String[]> updatedPrices = applyDiscount(products, discount);

        Object[][] inventory = {
            {"Скакалка", 550.00, 8},
            {"Шлем", 3750.00, 4},
            {"Мяч", 2900.00, 10}
        };
        Object[] mostValuableItem = mostExpensive(inventory);
        System.out.println("Задание 1: "+ isStrangePare("ratio", "orator"));
        
        System.out.println("Задание 2:");
        for (String[] product : updatedPrices) {
            System.out.println("Product: " + product[0] + ", New Price: " + product[1]);
        }
        System.out.println("Задание 3: "+sucsessShoot(0, 0, 5, 2, 2));
        System.out.println("Задание 4: " + parityAnalysis(243));
        System.out.println("Задание 5: " + rps("камень","ножницы"));
        System.out.println("Задание 6: " + bugger(39));
        System.out.println("Задание 7:");
        if (mostValuableItem != null) {
            System.out.println("Наиболее ценный предмет: " + mostValuableItem[0] + " - " + mostValuableItem[1]);
        }
        System.out.println("Задание 8: " + longestUnique("abcba"));
        System.out.println("Задание 9: "+isPrefix("automation", "auto-") + " " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("Задание 10: " + doesBrickFit(1, 1, 1, 1, 1));
    }
    public static boolean isStrangePare(String s1, String s2) {
        if (s1.equals("") && s2.equals("")){
            return true;
        }
        else{
            char s11 = s1.charAt(0);
            char s12 = s1.charAt(s1.length()-1);
            char s21 = s2.charAt(0);
            char s22 = s2.charAt(s2.length()-1);
            return (s11==s22 && s12==s21);
        }
    }
    public static boolean parityAnalysis(int x) {
        int sum = 0;
        int y = x;
        while (y>0) {
            sum = sum + y % 10;
            y = y/10;
        }
        return (x % 2) == (sum % 2);
    }
    
    public static List<String[]> applyDiscount(List<String[]> products, double discount) {
        List<String[]> updatedPrices = new ArrayList<>();

        for (String[] product : products) {
            String name = product[0];
            double price = Double.parseDouble(product[1]);
            double discountedPrice = price * (1 - discount);
            
            int finalPrice = (int) Math.round(Math.max(discountedPrice, 1));

            updatedPrices.add(new String[]{name, String.valueOf(finalPrice)});
        }

        return updatedPrices;
    }
    public static boolean sucsessShoot(double x1, double y1, double r, double x2, double y2){
        double distanceSquared = ((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        
        
        return distanceSquared <= r*r;
    }

    public static String rps(String p1, String p2){
        if (p1.equals(p2)) {
            return "Ничья!";
        }

        if ((p1.equals("камень") && p2.equals("ножницы")) ||
            (p1.equals("ножницы") && p2.equals("бумага")) ||
            (p1.equals("бумага") && p2.equals("камень"))) {
            return "Игрок 1 выигрывает!";
        } else {
            return "Игрок 2 выигрывает!";
        }
    }
    public static int bugger(int x){
        int c = 0;

        while (x >= 10){
            int p = 1;
            while (x>0){
                p *= x%10;
                x /= 10;
            }
        x = p;

        c++;

        }
        return c;
    }
    public static Object[] mostExpensive(Object[][] inventory) {
        Object[] mostValuableItem = null;
        double maxValue = 0;

        for (Object[] item : inventory) {
            String name = (String) item[0];
            double price = (double) item[1];
            int quantity = (int) item[2];

            
            double totalValue = price * quantity;

            
            if (totalValue > maxValue) {
                maxValue = totalValue;
                mostValuableItem = new Object[]{name, totalValue};
            }
        }

        return mostValuableItem;
    }

    public static String longestUnique(String s) {
        String longestSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (hasUniqueChars(substring) && substring.length() > longestSubstring.length()) {
                    longestSubstring = substring;
                }
            }
        }
        return longestSubstring;
    }
    private static boolean hasUniqueChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isPrefix(String word, String prefix) {
        if (word == null || prefix == null) {
            return false;
        }
        prefix = prefix.substring(0,prefix.length()-1);
        return word.startsWith(prefix);
    }

    
    public static boolean isSuffix(String word, String suffix) {
        if (word == null || suffix == null) {
            return false;
        }
        suffix = suffix.substring(1);
        return word.endsWith(suffix);
    }
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w) ||
                (c <= w && a <= h) || (c <= h && a <= w);
    }
}



