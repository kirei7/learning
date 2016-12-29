package com.userok.learning.softgrouptest;

import com.userok.learning.softgrouptest.N2Polynomial.Monomial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class {@code N1TriangleTest} contains main method, which
 * can be considered as the solution of task №1*/
public class N2PolynomialTest {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean isLegal;    //need this to check if the user input was legal
        do {
            try {
                int a, b, n;
                isLegal = true;
                System.out.print("Enter 'a' value: ");
                a = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter 'b' value: ");
                b = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the polynome's exponent(n): ");
                n = Integer.parseInt(scanner.nextLine());
                N2Polynomial polynomial = new N2Polynomial(a,b,n);
                System.out.println(polynomial.toString());
            } catch (IllegalArgumentException ex) {
                isLegal = false;
                System.err.println(ex.getMessage());
                /*wait a small amount of time so that message writes to "err" stream
                * and don't get messed with message written to "out" stream*/
                Thread.sleep(200l);
            }
        } while (!isLegal); //while input is not legal - request a new input from user
    }
}
