package com.userok.learning.softgrouptest.n5;

import java.math.BigDecimal;
import java.util.*;

import static com.userok.learning.softgrouptest.n5.SalaryCalculator.calculate;

public class Main {
    public static void main(String[] args) {
        Collection<Employee> employees = createCollection();

        //problem a)
        /*Sort the collection of employees in descending order by the average
        monthly salary. In the case of equal salary – by the name. Write ID, name and
        monthly salary for all employees from collection.*/
        System.out.println("Problem a)");
        Collection<Employee> sorted = sortAndReverse(employees);
        display(sorted);

        //problem b)
        /*Write information about first five employees from collection (problem a)*/
        System.out.println("Problem b)");
        Collection<Employee> firstFive = pickFirst(5, sorted);
        display(firstFive);

        //problem c)
        /*Write ID of three last employees from collection (problem b).*/
        System.out.println("Problem c)");
        Collection<Employee> lastThree = pickLast(3, firstFive);
        displayIDs(lastThree);

        //problem d)
        /*Write code for reading and writing collection of these objects from (into)
        file.*/
        System.out.println("Problem d)");
        CSVFileHandler CSVFileHandler = new CSVFileHandler();
        //problem e)
        /*Write code for handling the incorrect format of incoming file.*/
        try {
            //read from file
            Collection<Employee> fromFile = CSVFileHandler.readFromFile("emps.csv");
            System.out.println("Readed from file");
            display(fromFile);

            //write to file
            CSVFileHandler.writeToFile("newEmps.csv", employees);
            System.out.println("Writed to file");
            display(CSVFileHandler.readFromFile("newEmps.csv"));

            //if there is any errors with file handling, print a message about it
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //util functions below, needed to remove code duplication and improver readability
    //of the main() method

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
