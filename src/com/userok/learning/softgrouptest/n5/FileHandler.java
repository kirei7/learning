package com.userok.learning.softgrouptest.n5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class FileHandler {
    public Collection<Employee> readFromFile(String fileName)
            throws ParseException, FileNotFoundException{
        Collection<Employee> employees = new ArrayList<>(10);
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] comps = line.split(",");
                employees.add(
                        new Employee(
                                Integer.parseInt(comps[0]),
                                comps[1],
                                new BigDecimal(Double.parseDouble(comps[2]))
                        )
                );
            }
            sc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employees;
    }

    public void writeToFile(String fileName, Collection<Employee> employees) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Employee employee : employees) {
                writer.write(employee.getId() + ",");
                writer.write(employee.getName() + ",");
                writer.write(employee.getAvgSalary().toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
