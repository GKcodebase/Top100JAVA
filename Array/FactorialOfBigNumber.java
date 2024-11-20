package Array;

import java.math.BigInteger;

public class FactorialOfBigNumber {
    static void factorial(int n) {
        BigInteger f = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Factorial is  " + f);
    }

    public static void main(String args[]) {
        factorial(20);
    }
}
