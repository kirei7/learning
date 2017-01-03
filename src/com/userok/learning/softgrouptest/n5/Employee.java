package com.userok.learning.softgrouptest.n5;

import java.math.BigDecimal;
/*Class for representing an information about employee*/
public class Employee implements Comparable<Employee>{
    //counter field is needed to give each employee
    //his unique id
    private static long counter;
    private long id;
    private String name;
    private BigDecimal avgSalary;

    public Employee(String name, BigDecimal avgSalary) {
        //coma in the name will cause wrong parsing from a file(see CSVFileHandler class)
        if (name.contains(","))
            throw new IllegalArgumentException("Employee name shouldn't contain comas");
        this.name = name;
        //set precision of a number to 2 digits after the point
        this.avgSalary = avgSalary.setScale(2, BigDecimal.ROUND_HALF_UP);
        id = ++counter;
    }
    public Employee(int id, String name, BigDecimal avgSalary) {
        //there should be more complicated protection of ID's uniqueness, but
        //since it is one-off program, it should be fine
        if (counter < id) counter = id;
        this.id = id;
        this.name = name;
        this.avgSalary = avgSalary.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    //getters, setters

    public String getName() {
        return name;
    }
    public BigDecimal getAvgSalary() {
        return avgSalary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAvgSalary(BigDecimal avgSalary) {
        this.avgSalary = avgSalary.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return getId() == employee.getId();

    }

    @Override
    public int hashCode() {
        return new Long(id).hashCode();
    }

    @Override
    public int compareTo(Employee o) {
        int result = avgSalary.compareTo(o.avgSalary);
        if (result == 0) {
            return name.compareTo(o.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return  name +
                " with average salary=" + avgSalary;
    }
}
