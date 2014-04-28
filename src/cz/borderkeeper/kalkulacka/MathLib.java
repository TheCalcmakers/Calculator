package cz.borderkeeper.kalkulacka;

public abstract class MathLib {

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double mySqrt(double a) {
        return Math.sqrt(a);
    }

    public static double myPow(double a,double exp) {
        return Math.pow(a,exp);
    }

    public static double add(double a, double b) {
        return a+b;
    }

    public static double sub(double a, double b) {
        return a-b;
    }

    public static double mod(double a, double b) {
        return a/b;
    }

    public static double mul(double a, double b) {
        return a*b;
    }

}
