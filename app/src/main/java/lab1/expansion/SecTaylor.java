package lab1.expansion;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecTaylor {

    private static int factorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public static double compute(double x) {
       return 1 + Math.pow(x, 2) / factorial(2) + 5 * Math.pow(x, 4) / factorial(4) +
               61 * Math.pow(x, 6) / factorial(6) + 1385 * Math.pow(x, 8) / factorial(8);
    }
}
