import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class tasks4{
    public static void main(String[] args){
        int[] nums = {0, 31, 28, 10, 29};
        int[][] labyrinth = {
            {1, 3, 1},
            {1, -1, 1},
            {4, 2, 1}
        };
        Object [] result = labirint(labyrinth);
        int[] decoded = Decode("MTUCI","MKIIT");
        System.out.println("Задание1: "+nonRepeat("abracadabra"));
        System.out.println("задание 2: "+ bruteForce(1, 5));
        System.out.println("задание 3: "+Encode(nums, "MKIIT")+"/"+Arrays.toString(decoded));
        System.out.println("Задание 4: "+split("()()()"));
        System.out.println("задание 5: "+shortHand("abbccc"));
        System.out.println("Задание 6: "+convertToRoman(26));
        System.out.println("Задание 7: "+uniqueSubstring("31312131"));
        System.out.println("Задание 8: "+Arrays.toString(result));
        System.out.println("задание 9: "+numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println("Задание 10: "+fibString("CCCABDD"));
    }
    //Задание 1
    public static String nonRepeat(String s) {
        
        String lowerCaseStr = s.toLowerCase();
        HashMap<Character, Integer> charCount = new HashMap<>();

        
        for (char c : lowerCaseStr.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        
        return removeCharsRecursive(s, charCount, 0);
    }

        private static String removeCharsRecursive(String s, HashMap<Character, Integer> charCount, int index) {
            
            if (index >= s.length()) {
                return "";
            }

            char currentChar = s.charAt(index);
            String remainingString = removeCharsRecursive(s, charCount, index + 1);

        
            if (charCount.get(Character.toLowerCase(currentChar)) > 3) {
                return remainingString;
            } else {
                return currentChar + remainingString;
            }
        }
    //задание 2
    public static List<String> bruteForce(int n, int k){
        List<String> result = new ArrayList<>();
        if (n > k) return result;
        generateCombinations("", n, k, result);
        
        return result;
    }

    private static void generateCombinations(String prefix, int n, int k, List<String> result) {
        if (prefix.length() == n) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < k; i++) {
            char currentChar = (char) ('0' + i);
            if (!prefix.contains(String.valueOf(currentChar))) {
                generateCombinations(prefix + currentChar, n, k, result);
            }
        }
    }
    //Задание 3
    public static String Encode(int[] numbers, String key) {
        StringBuilder encoded = new StringBuilder();
        
        for (int i = 0; i < numbers.length; i++) {
            char encodedChar = (char) (numbers[i] ^ key.charAt(i % key.length()));
            encoded.append(encodedChar);
        }
        
        return encoded.toString();
    }

    
    public static int[] Decode(String encoded, String key) {
        int[] decodedNumbers = new int[encoded.length()];
        
        for (int i = 0; i < encoded.length(); i++) {
            decodedNumbers[i] = encoded.charAt(i) ^ key.charAt(i % key.length());
        }
        
        return decodedNumbers;
    }
    //Задание 4
    public static List<String> split(String s) {
        List<String> clusters = new ArrayList<>();
        int balance = 0;
        StringBuilder currentCluster = new StringBuilder();

        for (char ch : s.toCharArray()) {
            currentCluster.append(ch);

            
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }


            if (balance == 0) {
                clusters.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }

        return clusters;
    }
    //Задание 5
    public static String shortHand(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                
                result.append(s.charAt(i));
                if (count > 1) {
                    result.append("*").append(count);
                }
                count = 1;
            }
        }

        return result.toString();
    }
    //Задание 6
    public static String convertToRoman(int num) {
        if (num < 1 || num > 1502) {
            throw new IllegalArgumentException("Number must be between 1 and 1502");
        }
        String[] romanNumerals = {
            "M", "CM", "D", "CD", "C",
            "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"
        };
        int[] values = {
            1000, 900, 500, 400, 100,
            90, 50, 40, 10,
            9, 5, 4, 1
        };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romanNumerals[i]);
                num -= values[i];
            }
        }
        return result.toString();
    
    }
    //Задание 7
    public static String uniqueSubstring(String digits) {
        int[] count = new int[10];
        for (char digit : digits.toCharArray()) {
            count[digit - '0']++;
        }
        int maxCount = 0;
        int fi = -1;
        char maxDigit = '0';

        
        for (int i = 0; i < digits.length(); i++) {
            char dig = digits.charAt(i);
            int digitCount = count[dig - '0'];

            
            if (digitCount > maxCount || (digitCount == maxCount && fi == -1)) {
                maxCount = digitCount;
                maxDigit = dig;
                fi = i;
            }
        }

        
        if (fi % 2 ==0){
            return "чёт";
        }
        else{
            return "нечёт";
        }
    }
    //Задание 8
    public static Object[] labirint(int[][] matrix) {
        int n = matrix.length;
        int[][] cost = new int[n][n];
        String[][] path = new String[n][n];

        
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            Arrays.fill(path[i], "");
        }

        
        if (matrix[n - 1][n - 1] < 0) {
            return new Object[]{"Прохода нет"};
        }
        
        cost[n - 1][n - 1] = matrix[n - 1][n - 1];
        path[n - 1][n - 1] = String.valueOf(matrix[n - 1][n - 1]);

        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < 0) continue; 

                
                if (i > 0 && cost[i][j] != Integer.MAX_VALUE) {
                    if (cost[i][j] + matrix[i - 1][j] < cost[i - 1][j]) {
                        cost[i - 1][j] = cost[i][j] + matrix[i - 1][j];
                        path[i - 1][j] = path[i][j] + "-" + matrix[i - 1][j];
                    }
                }

                
                if (j > 0 && cost[i][j] != Integer.MAX_VALUE) {
                    if (cost[i][j] + matrix[i][j - 1] < cost[i][j - 1]) {
                        cost[i][j - 1] = cost[i][j] + matrix[i][j - 1];
                        path[i][j - 1] = path[i][j] + "-" + matrix[i][j - 1];
                    }
                }
            }
        }


        if (cost[0][0] == Integer.MAX_VALUE) {
            return new Object[]{"Прохода нет"};
        } else {
            return new Object[]{path[0][0], cost[0][0]};
        }
    }
    //задание 9
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        String[] orderedWords = new String[words.length];

        for (String word : words) {
            int position = -1;
            for (char ch : word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    position = Character.getNumericValue(ch);
                    break;
                }
            }
            
            if (position > 0 && position <= words.length) {
                orderedWords[position - 1] = word.replaceAll("\\d", "");
            }
        }

        
        for (String word : orderedWords) {
            if (word == null) {
                return "Прохода нет";
            }
        }
        return String.join(" ", orderedWords);
    }
    //Задание 10
    private static boolean isFibonacci(int num) {
        if (num < 0) return false;
        int a = 0;
        int b = 1;
        while (b < num) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b == num || num == 0;
    }

    public static boolean fibString(String str) {
        
        int[] count = new int[256];

        
        for (char ch : str.toCharArray()) {
            count[ch]++;
        }

        
        for (int c : count) {
            if (c > 0 && !isFibonacci(c)) {
                return false;
            }
        }

        return true;
    }
}