package com.userok.learning.softgrouptest;

import java.util.ArrayList;
import java.util.List;

/*Class for displaying numbers from a
* given string*/
public class N3StringParser {

    //here the numbers of a string are saved
    //it contains Numbers, so we can put
    // not only integers, but also floating point numbers
    private List<Number> numbers;

    public N3StringParser(String str) {
        //first, we divide a string into separate blocks:
        //single numbers (like "451") or expressions (like "5-4", "*1", "9+")
        String[] strings = str.split("[^0-9^\\*^\\+^\\-^/]+");

        List<String> temp = new ArrayList<>(strings.length);
        //add to list only strings which are single numbers or
        //correct expressions (number-sign-number)
        for (String string : strings) {
            if (!string.matches("([0-9]+|[0-9]+[\\*\\+\\-/][0-9]+)")) continue;
            temp.add(string);
        }
        //retrieving a list of numbers
        numbers = strToNums(temp);
    }

    //a function which converts strings to numbers
    private List<Number> strToNums(List<String> temp) {
        List<Number> nums = new ArrayList<>(temp.size());
        for (String string : temp) {
            Number n = null;
            try {
                //if it is a single number, parse it
                n = Integer.parseInt(string);
                //if it's not single number, we get NF exception
            } catch (NumberFormatException ex) {
                //in each "if" statement we check if the sign between
                //the numbers is a specific to that block sign
                //and accordingly to this parse the expression
                if (string.contains("/"))
                {
                    String[] pair = string.split("/");
                    Double a = Double.parseDouble(pair[0]);
                    Double b = Double.parseDouble(pair[1]);
                    if (a % b == 0) n = new Double(a / b).intValue();
                    else n = a / b;
                } else
                if (string.contains("+"))
                {
                    String[] pair = string.split("\\+");
                    n = Integer.parseInt(pair[0]) + Integer.parseInt(pair[1]);
                } else
                if (string.contains("-"))
                {
                    String[] pair = string.split("\\-");
                    n = Integer.parseInt(pair[0]) - Integer.parseInt(pair[1]);
                } else
                if (string.contains("*"))
                {
                    String[] pair = string.split("\\*");
                    n = Integer.parseInt(pair[0]) * Integer.parseInt(pair[1]);
                }

            }
            nums.add(n);
        }
        return nums;
    }

    //function for displaying a result - to satisfy task conditions
    public void displayResult() {
        System.out.println("Numbers");
        for (Number number : numbers) System.out.println(number.toString());
        System.out.println("Max: " + numbers.get(maxNum()));
        System.out.println("Min: " + numbers.get(minNum()));
    }

    private int maxNum() {
        int num = 0;
        double max = numbers.get(num).doubleValue();
        for (int i = 1; i < numbers.size(); i++) {
            double t = numbers.get(i).doubleValue();
            if (t > max) {
                max = t;
                num = i;
            }
        }
        return num;
    }
    private int minNum() {
        int num = 0;
        double min = numbers.get(num).doubleValue();
        for (int i = 1; i < numbers.size(); i++) {
            double t = numbers.get(i).doubleValue();
            if (t < min) {
                min = t;
                num = i;
            }
        }
        return num;
    }


}
