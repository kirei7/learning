package com.userok.learning.softgrouptest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class {@code N1TriangleTest} contains main method, which
 * can be considered as the solution of task №1*/
public class N1TriangleTest {
    static private N1Triangle calc = new N1Triangle();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean isLegal;    //need this to check if the user input was legal
        do {
            try {
                int n;
                isLegal = true;
                System.out.print("Enter the number of Pascal's triangle line: ");
                n = Integer.parseInt(scanner.nextLine());
                printLine(n);
            } catch (IllegalArgumentException ex) {
                isLegal = false;
                System.err.println(ex.getMessage());
                /*wait a small amount of time so that message writes to "err" stream
                * and don't get messed with message written to "out" stream*/
                Thread.sleep(200l);
            }
        } while (!isLegal); //while input is not legal - request a new input from user
    }

    public static void customTests() {
        //test case 1 - print single line
        System.out.println();
        System.out.println("Case 1:");
        printLine(5);

        //test case 2 - print Pascal's triangle up to 10th line
        System.out.println();
        System.out.println("Case 2:");
        for (int i = 0; i < 10; i++) {
            printLine(i);
        }

        //test case 3 - illegal argument should cause exception
        System.out.println();
        System.out.println("Case 3:");
        try {
            printLine(-1);
        } catch (IllegalArgumentException ex) {
            System.out.println("IAException thrown!");
        }
    }


    //prints a single line of the triangle to a standard output
    private static void printLine(int i) {
        int[] line = calc.calcSingleLine(i);
        System.out.println(Arrays.toString(line));
    }
}
