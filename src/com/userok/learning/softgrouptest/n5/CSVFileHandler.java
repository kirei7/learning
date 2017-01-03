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
/*CSVFileHandler works with files*/
public class CSVFileHandler implements FileHandler {
    //method for reading collection from a file
    @Override
    public Collection<Employee> readFromFile(String fileName)
            throws ParseException, FileNotFoundException{
        //create an empty collection with an approximate size
        Collection<Employee> employees = new ArrayList<>(10);
        try {
            //scanner from which we'll be reading data
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                //read and parse each line into single Employee object
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

    //method to write collection into a file
    //if file doesn't exists, it will create it
    @Override
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
