package lab1.expansion;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecTaylor {

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public static double secTaylor(double x, int n) {
        double result = 1.0;
        double term = 1.0;
        for (int i = 1; i <= n; i++) {
            term *= -x * x / (2 * i - 1) / (2 * i);
            result += term;
        }
        return result;
    }

    public static boolean checkCalculator(double x, int n) {
        double sec = secTaylor(x, n);
        double realSec = 1 / Math.cos(x);

        System.out.println(sec);
        System.out.println(realSec);


        if (Math.abs(sec - realSec) < 0.1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        checkCalculator(6.28, 21);
    }
}
