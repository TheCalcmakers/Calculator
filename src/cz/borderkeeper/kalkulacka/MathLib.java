package cz.borderkeeper.kalkulacka;
/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Abstract class holding some key mathematical methods.
 */
public abstract class MathLib {

   /*
    * @brief Calculates a factorial.
    * @param n Integer for calculation.
    * @return Calculated integer.
    */
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    /*
    * @brief Calculates a square root of a Double.
    * @param a Double for calculation.
    * @return Calculated double.
    */
    public static double mySqrt(double a) {
        return Math.sqrt(a);
    }
   /*
    * @brief Calculates a power of a number using exp.
    * @param a Double that is being powered.
    * @param exp Double that is powering.
    * @return Calculated double.
    */
    public static double myPow(double a,double exp) {
        return Math.pow(a,exp);
    }
   /*
    * @brief Calculates a summary.
    * @param a Numerator
    * @param b Summand
    * @return Calculated double.
    */
    public static double add(double a, double b) {
        return a+b;
    }
   /*
    * @brief Calculates a subtraction.
    * @param a Numerator
    * @param b Summand
    * @return Calculated double.
    */
    public static double sub(double a, double b) {
        return a-b;
    }
   /*
    * @brief Calculates a division.
    * @param a Dividend
    * @param b Divisor
    * @return Calculated double.
    */
    public static double mod(double a, double b) {
        return a/b;
    }
   /*
    * @brief Calculates a multiplication.
    * @param a Multiplicand
    * @param b Multiplier
    * @return Calculated double.
    */
    public static double mul(double a, double b) {
        return a*b;
    }

}
