package com.userok.learning.softgrouptest.n5;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

import static com.userok.learning.softgrouptest.n5.SalaryCalculator.calculate;

public class Main {
    public static void main(String[] args) {
        Collection<Employee> employees = createCollection();

        //problem a)
        System.out.println("Problem a)");
        Collection<Employee> sorted = sortAndReverse(employees);
        display(sorted);

        //problem b)
        System.out.println("Problem b)");
        Collection<Employee> firstFive = pickFirst(5, sorted);
        display(firstFive);

        //problem c)
        System.out.println("Problem c)");
        Collection<Employee> lastThree = pickLast(3, firstFive);
        displayIDs(lastThree);

        //problem d)
        System.out.println("Problem d)");
        FileHandler fileHandler = new FileHandler();
        //problem e)
        try {
            Collection<Employee> fromFile = fileHandler.readFromFile("emps.csv");
            System.out.println("Readed from file");
            display(fromFile);
            fileHandler.writeToFile("newEmps.csv", employees);
            System.out.println("Writed to file");
            display(fileHandler.readFromFile("newEmps.csv"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void displayIDs(Collection<Employee> employees) {
        System.out.println("IDs:");
        for (Employee employee : employees) {
            System.out.println(employee.getId());
        }
        System.out.println();
    }

    private static Collection<Employee> pickLast(int number, Collection<Employee> employees) {
        List<Employee> temp = new ArrayList<>(employees);
        Collections.reverse(temp);
        return pickFirst(3, temp);
    }

    private static Collection<Employee> pickFirst(int number, Collection<Employee> employees) {
        List<Employee> collection = new ArrayList<>(number);
        Iterator<Employee> iterator = employees.iterator();
        for (int i = 0; i < number; i++) {
            collection.add(iterator.next());
        }
        return collection;
    }

    private static void display(Collection<Employee> employees) {
        System.out.println("Collection:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + " " + employee.toString());
        }
        System.out.println();
    }

    private static Collection<Employee> sortAndReverse(Collection<Employee> employees) {
        List<Employee> sorted = new ArrayList<>(employees);
        Collections.sort(sorted);
        Collections.reverse(sorted);
        return sorted;
    }

    private static Collection<Employee> createCollection() {
        Collection<Employee> employees = new ArrayList<>(6);
        employees.add(
                new Employee("Martin", calculate(Payment.FIXED, new BigDecimal(800)))
        );
        employees.add(
                new Employee("Austin", calculate(Payment.HOURLY_WAGE, new BigDecimal(5.5)))
        );
        employees.add(
                new Employee("Yan", calculate(Payment.HOURLY_WAGE, new BigDecimal(5.5)))
        );
        employees.add(
                new Employee("Dean", calculate(Payment.HOURLY_WAGE, new BigDecimal(5.5)))
        );
        employees.add(
                new Employee("Robert", calculate(Payment.FIXED, new BigDecimal(800)))
        );
        employees.add(
                new Employee("Will", calculate(Payment.HOURLY_WAGE, new BigDecimal(6.345)))
        );
        return employees;
    }

}
