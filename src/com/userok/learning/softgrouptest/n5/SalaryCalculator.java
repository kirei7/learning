package com.userok.learning.softgrouptest.n5;

import java.math.BigDecimal;

//this class contains a rules to the calculation of the rent
public class SalaryCalculator {
    public static BigDecimal calculate(Payment type, BigDecimal amount) {
        switch (type) {
            case HOURLY_WAGE:
                return new BigDecimal(amount.doubleValue() * 20.8 * 8);
            case FIXED:
                return amount;
            default:
                throw new IllegalArgumentException("Unknown payment type");
        }
    }
}
