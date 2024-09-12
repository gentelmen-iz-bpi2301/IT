public class Palindromes {
    public static void main(String[] args) {
        System.out.println("Палиндромы");
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)){
                System.out.println(s);
            }
        }
    }
    public static String reverseString(String s){
        String result = "";
        for(int i = 0; i < s.length();i++){
            result = s.charAt(i)+result;
        }
        return result;
    }
    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));

}
}