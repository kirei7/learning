package com.userok.learning.softgrouptest;

import java.util.Arrays;

/**
 * The class {@code N1Triangle} contains a single public
 * method for calculating Pascal's triangle single line
 * */
public class N1Triangle {
    /**
     * Returns an array which represents a numerated line of
     * the Pascal's triangle
     * @param n a number of the line
     * @return an array which represents a numerated line
     * @throws IllegalArgumentException if {@code n} is less then zero
     * */
    public int[] calcSingleLine(int n) {
        if (n < 0)
            throw new IllegalArgumentException
                    ("Line number must be non-negative integer");
        int[] line = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            line[i] = fl(n) / ( fl(i) * fl(n - i) );
        }
        return line;
    }

    /**
     * Calculates and returns the factorial of a number
     * @param n number
     * @return factorial of the number {@code n
     * @throws IllegalArgumentException if {@code n} is less then zero
     * }*/
    private int fl(int n) {
        if (n < 0)
            throw new IllegalArgumentException
                    ("Number for a factorial calculation must be non-negative integer");
        int mul = 1;
        for (int i = 1; i <= n; i++) {
            mul *= i;
        }
        return mul;
    }

}
