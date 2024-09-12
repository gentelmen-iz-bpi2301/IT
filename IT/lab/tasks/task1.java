
public class task1 {
    public static double convert(double x) {
        return x*3.785;
    }
    
    public static void main (String [] args) {
        System.out.println("Задание 1:");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        
        System.out.println("Задание 2:");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        
        System.out.println("Задание 3:");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        
        System.out.println("Задание 4:");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        
        System.out.println("Задание 5:");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        
        System.out.println("Задание 6:");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        
        System.out.println("Задание 7:");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println("Задание 8:");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println("Задание 9:");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println("Задание 10:");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    
    public static int fitCalc(int x, int y){
        return x*y;
    }
    public static int containers(int x, int y, int z) {
        return x*20+y*50+z*100;
    }
    public static String triangleType(int x, int y, int z) {
        String result = "";
        if (x+y<z || x+z<y || y+z<x) {
            result = "not a triangle";
        }
        else if (x==y & x==z) {
            result = "isosceles";
        }
        else if (x==y & x!=z || x==z & x!=y) {
            result = "equilateral";
        }
        else if (x!=y & x!=z & y!=z) {
            result = "different-sided";
        }
        return result;
    }
    public static int ternaryEvaluation(int x, int y) {
        return x>y ? x:y;
    }
    public static double howManyItems(double x, double y, double z) {
        z = (int)(x/(y*z*2));
        return z;
    }
    public static int factorial(int x) {
        int y = 1;
        for(int i=1; i<=x; i++) {
            y = y*i;
        }
        return y;
    }
    public static int gcd(int x, int y) {
        int g = 1;
        for (int i = 1; i<=x && i<=y; i++) {
            if (x%i==0 && y%i==0) {
                g = i;
            }
        }
        return g;
    }
    public static int ticketSaler(int x, int y) {
        return (x*y)*72/100;
    }
    public static int tables(int x, int y) {
        if (x > y*2){
            return (x - y*2 + 1)/2;
        }
        else {
            return 0;
        }
    }
}
