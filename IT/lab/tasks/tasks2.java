import java.util.Arrays;
public class tasks2 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(duplicateChars("Barack","Obama"));
        System.out.println("Задание 2:");
        int[] num = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(num));
        System.out.println("Задание 3:");
        System.out.println(getInitials("simonov sergey evgenevich"));
        double[] n = {3.5, 7.0, 1.5, 9.0, 5.5};
        System.out.println("Задание 4:");
        System.out.println(Arrays.toString(normalizator(n)));
        double[] arr = {1.6, 0, 212.3, 34.8, 0, 27.5};
        System.out.println("Задание 5:");
        System.out.println(Arrays.toString(compressedNums(arr)));
        System.out.println("Задание 6:");
        System.out.println(camelToSnake("helloWorld"));
        int[] nums = {3, 5, 8, 1, 2, 4};
        System.out.println("Задание 7:");
        System.out.println(secondBiggest(nums));
        System.out.println("Задание 8:");
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
        System.out.println("Задание 9:");
        System.out.println(equal(8, 1, 8));
        System.out.println("Задание 10:");
        System.out.println(isAnagram("hello", "world"));
    }

    public static String duplicateChars(String str1, String str2) {
        String st = str1.toLowerCase();
        String s = str2.toLowerCase();
        String result = "";
        for (int i = 0; i < st.length(); i++) {
            if (s.indexOf(st.charAt(i))==-1) {
                result = result+st.charAt(i);
            }
        }
        return result;
    }
    public static int dividedByThree(int[] array){
        int c = 0;
        for (int n: array) {
            if (n % 2 != 0 && n % 3 == 0){
                c++;
            }
        }
        return c;
    }
    public static String getInitials(String s) {
        String[] spl = s.split(" ");
        String nameInitial = spl[1].substring(0, 1).toUpperCase()+".";
        String surname = spl[0].substring(0, 1).toUpperCase() + spl[0].substring(1);
        String patronymicsInitial = spl[2].substring(0, 1).toUpperCase()+".";
        return nameInitial + patronymicsInitial + " " + surname;
    }
    public static double[] normalizator(double[] array) {
        double max = array[0];
        double min = array[0];
        for (double n: array){
            if (min > n) {
                min = n;
            }
            if (max < n) {
                max = n;
            }
        }

        double[] normalizedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            normalizedArray[i] = (array[i]-min)/(max-min);
        }
        return normalizedArray;
    }
    public static double[] compressedNums(double[] array) {
        double[] withoutZero = Arrays.stream(array).filter(n -> n !=0).toArray();
        Arrays.sort(withoutZero);
        return withoutZero;
    }
    public static String camelToSnake(String str) {
        String first = "";
        String second = "";
        boolean registre = true;

        while (registre) {
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (Character.isUpperCase(letter)) {
                    first = str.substring(0, i);
                    second = str.substring(i);
                    second = second.toLowerCase();
                    registre = false;
                }
            }
        }
    return first + "_" + second;
    }
    public static int secondBiggest(int[] array) {
        int max = 0;
        int max2 = 0;
        for (int i: array){
            if (max == 0 || i > max ){
                max2 = max;
                max = i;
            }
            else if (i != max && (max2 == 0 || i > max2)){
                max2 = i;
            }
            }
            return max2;
        }
        public static String localReverse(String s, char mark) {
            int start = 0;
            StringBuilder result = new StringBuilder();
            while (start < s.length()) {
                int markStart = s.indexOf(mark, start);
                if (markStart == -1) {
                    
                    result.append(s.substring(start));
                    break;
                }
    
                
                result.append(s.substring(start, markStart));
    
                
                int markEnd = s.indexOf(mark, markStart + 1);
                if (markEnd == -1) {
                    
                    result.append(s.substring(markStart));
                    break;
                }
    
                
                String toReverse = s.substring(markStart + 1, markEnd);
                result.append(mark);
                result.append(new StringBuilder(toReverse).reverse());
                result.append(mark);
                
                start = markEnd + 1;
            }
    
            return result.toString();
        }
        public static int equal(int x, int y, int z) {
            int count = 0;
            if (x == y && y == z){
                count = 3;
            }
            else if (x == y && y != z || x == z && x != y || y == z && x != y) {
                count = 2;
            }
            else{
                count = 0;
            }
            return count;
        }
        public static String isAnagram(String str1, String str2){
            String s1 = str1.toLowerCase();
            String s2 = str2.toLowerCase();
            String result = "";
            if (s1.length() != s2.length()){
                result = "Is not an anogram";
            }
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if (Arrays.equals(arr1, arr2)) {
                result = "Is anogram";
            }
            else {
                result = "Is not an anogram";
            }
            return result;
        }
    }

