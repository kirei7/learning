package com.userok.learning.softgrouptest.n5;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Collection;

public interface FileHandler {

    Collection<Employee> readFromFile(String fileName)
            throws ParseException, FileNotFoundException;

    void writeToFile(String fileName, Collection<Employee> employees);
}
