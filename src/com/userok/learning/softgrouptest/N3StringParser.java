package com.userok.learning.softgrouptest;

import java.util.ArrayList;
import java.util.List;

public class N3StringParser {

    private List<Number> numbers;

    public N3StringParser(String str) {
        String[] strings = str.split("[^0-9^\\*^\\+^\\-^/]+");

        List<String> temp = new ArrayList<>(strings.length);
        for (String string : strings) {
            if (!string.matches("([0-9]+|[0-9]+[\\*\\+\\-/][0-9]+)")) continue;
            temp.add(string);
        }
        numbers = strToNums(temp);
    }

    private List<Number> strToNums(List<String> temp) {
        List<Number> nums = new ArrayList<>(temp.size());
        for (String string : temp) {
            Number n = null;
            try {
                n = Integer.parseInt(string);
            } catch (NumberFormatException ex) {
                String delimeter = null;
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
