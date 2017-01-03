package com.userok.learning.softgrouptest.n5;

import java.math.BigDecimal;

public class Employee implements Comparable<Employee>{
    private static int counter;
    private int id;
    private String name;
    private BigDecimal avgSalary;

    public Employee(String name, BigDecimal avgSalary) {
        if (name.contains(","))
            throw new IllegalArgumentException("Employee name shouldn't contain comas");
        this.name = name;
        this.avgSalary = avgSalary.setScale(2, BigDecimal.ROUND_HALF_UP);
        id = ++counter;
    }
    public Employee(int id, String name, BigDecimal avgSalary) {
        this.id = id;
        this.name = name;
        this.avgSalary = avgSalary.setScale(2, BigDecimal.ROUND_HALF_UP);
    }



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

    public int getId() {
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
        return getId();
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
