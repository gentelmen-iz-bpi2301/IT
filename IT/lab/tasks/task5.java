import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public class task5{
    public static void main(String[] args){
        String[] guessed = {"cat","create","sat"};
        int[] numbers = {1, 2, 3, 5, 6, 7, 8, 9};
        String[] scores = {"53%", "79%"};
        System.out.println("Задание 1: " + sameLetterPattern("ABAB","CDCD"));
        System.out.println("Задание 2: " + memeSum(26,39));
        System.out.println("Задание 3: " + digitsCount(4666));
        System.out.println("Задание 4: " + totalPoints("caster", guessed));
        System.out.println("Задание 5: " + longestRun(numbers));
        System.out.println("Задание 6: " + takeDownAverage(scores));
        System.out.println("Задание 7: " + canMove("rook", "A8", "H8"));
        System.out.println("Задание 8: " + maxPossible(9328, 456));
        System.out.println("Задание 9: " + timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println("Задание 10: " + isNew(123));
    }
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
    
        String pattern1 = createPattern(str1);
        String pattern2 = createPattern(str2);
    
        return pattern1.equals(pattern2);
    }
    
    private static String createPattern(String str) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        StringBuilder patternBuilder = new StringBuilder();
    
        for (char c : str.toCharArray()) {
            if (!charToIndex.containsKey(c)) {
            charToIndex.put(c, charToIndex.size());
            }
            patternBuilder.append(charToIndex.get(c));
        }
    
        return patternBuilder.toString();
    }
    public static int memeSum(int x1, int x2){
        StringBuilder result = new StringBuilder();
        String num1 = Integer.toString(x1);
        String num2 = Integer.toString(x2);
        if (num1.length()<num2.length()){
            while (num1.length()<num2.length()){
                num1 = "0"+num1;
            }
        }
        else if(num1.length()>num2.length()){
            while(num2.length()<num1.length()){
                num2 = "0"+num2;
            }
        }
        for (int i = 0; i<num1.length();i++){
            result.append(Character.getNumericValue(num1.charAt(i))+Character.getNumericValue(num2.charAt(i)));
        }
        return Integer.parseInt(result.toString());
    }
    public static int digitsCount(int number) {
        number = Math.abs(number);
        if (number == 0) {
            return 0;
        }
        return 1 + digitsCount(number / 10);
    }

    public static int totalPoints(String scrambledWord, String[] guessed) {
        int[] letterCount = getLetterCount(scrambledWord);
        int totalPoints = 0;

        for (String word : guessed) {
            if (isValidWord(word, letterCount)) {
                totalPoints += calculateWordPoints(word);
            }
        }

        return totalPoints;
    }
    private static int[] getLetterCount(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++; 
            }
        }
        return count;
    }
    private static boolean isValidWord(String word, int[] letterCount) {
        int[] wordCount = new int[26]; 

        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') { 
                wordCount[c - 'a']++;
                if (wordCount[c - 'a'] > letterCount[c - 'a']) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int calculateWordPoints(String word) {
        int length = word.length();
        switch (length) {
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 54;
            default:
                return 0;
        }
    }
    public static int longestRun(int[] numbers) {
        if (numbers.length == 0) return 0;

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(numbers[i] - numbers[i - 1]) == 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }
    public static String takeDownAverage(String[] scores) {
        int n = scores.length;
        double total = 0;
        for (String score : scores) {
            total += Integer.parseInt(score.replace("%", ""));
        }
        double currentAverage = total / n;
        double targetAverage = currentAverage * 0.95;
        double requiredScore = (targetAverage * (n + 1)) - total;
        int roundedScore = (int) Math.round(requiredScore);
        roundedScore = Math.max(0, Math.min(100, roundedScore));
        return roundedScore + "%";
    }
    public static boolean canMove(String piece, String start, String target) {
        int startX = start.charAt(0) - 'A'; // Преобразуем букву в индекс (0-7)
        int startY = start.charAt(1) - '1'; // Преобразуем цифру в индекс (0-7)
        int targetX = target.charAt(0) - 'A';
        int targetY = target.charAt(1) - '1';

        switch (piece.toLowerCase()) {
            case "pawn":
                return canPawnMove(startX, startY, targetX, targetY);
            case "knight":
                return canKnightMove(startX, startY, targetX, targetY);
            case "bishop":
                return canBishopMove(startX, startY, targetX, targetY);
            case "rook":
                return canRookMove(startX, startY, targetX, targetY);
            case "queen":
                return canQueenMove(startX, startY, targetX, targetY);
            case "king":
                return canKingMove(startX, startY, targetX, targetY);
            default:
                return false;
        }
    }

    private static boolean canPawnMove(int startX, int startY, int targetX, int targetY) {
        
        if (startX == targetX && targetY == startY + 1) {
            return true;
        }
        if (startX == targetX && startY == 1 && targetY == 3) {
            return true;
        }
        return false;
    }

    private static boolean canKnightMove(int startX, int startY, int targetX, int targetY) {
        int dx = Math.abs(startX - targetX);
        int dy = Math.abs(startY - targetY);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    private static boolean canBishopMove(int startX, int startY, int targetX, int targetY) {
        return Math.abs(startX - targetX) == Math.abs(startY - targetY);
    }

    private static boolean canRookMove(int startX, int startY, int targetX, int targetY) {
        return (startX == targetX || startY == targetY);
    }

    private static boolean canQueenMove(int startX, int startY, int targetX, int targetY) {
        return canRookMove(startX, startY, targetX, targetY) || canBishopMove(startX, startY, targetX, targetY);
    }

    private static boolean canKingMove(int startX, int startY, int targetX, int targetY) {
        return Math.abs(startX - targetX) <= 1 && Math.abs(startY - targetY) <= 1;
    }

    public static int maxPossible(int num1, int num2) {
        char[] digits1 = Integer.toString(num1).toCharArray();
        char[] digits2 = Integer.toString(num2).toCharArray();
        Arrays.sort(digits2);
        reverseArray(digits2);

        int j = 0;

        
        for (int i = 0; i < digits1.length; i++) {
            if (j < digits2.length && digits2[j] > digits1[i]) {
                digits1[i] = digits2[j];
                j++;
            }
        }

        
        return Integer.parseInt(new String(digits1));
    }

    private static void reverseArray(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        // Карта временных смещений
        Map<String, Double> timeOffsets = new HashMap<>();
        timeOffsets.put("Los Angeles", -8.00);
        timeOffsets.put("New York", -5.00);
        timeOffsets.put("Caracas", -4.30);
        timeOffsets.put("Buenos Aires", -3.00);
        timeOffsets.put("London", 0.00);
        timeOffsets.put("Rome", 1.00);
        timeOffsets.put("Moscow", 3.00);
        timeOffsets.put("Tehran", 3.30);
        timeOffsets.put("New Delhi", 5.30);
        timeOffsets.put("Beijing", 8.00);
        timeOffsets.put("Canberra", 10.00);

        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm");

        try {
            Date dateInCityA = inputFormat.parse(timestamp);
            double offsetA = timeOffsets.get(cityA);
            double offsetB = timeOffsets.get(cityB);
            double timeDifferenceInMillis = (offsetB - offsetA) * 3600000;
            Date dateInCityB = new Date((long) (dateInCityA.getTime() + timeDifferenceInMillis));
            return outputFormat.format(dateInCityB);

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNew(int number) {
        String numStr = String.valueOf(number);
        if (numStr.length() > 1 && numStr.charAt(0) == '0') {
            return false;
        }

        char[] digits = numStr.toCharArray();
        Arrays.sort(digits);
        String sortedNumStr = new String(digits);
        int sortedNum = Integer.parseInt(sortedNumStr);
        
        return sortedNum == number;
    }
}