package com.userok.learning.softgrouptest.n4;

/*kind of rental changed to enum;
* amountFor() method moved here and changed it's parameters list;
* some code rewrited to be more compact and readable*/
public class Rental {
    private KindOfRental kind;
    private int days;

    public Rental(KindOfRental kind, int days) {
        this.kind = kind;
        this.days = days;
    }

    public KindOfRental getKind() {
        return kind;
    }

    public void setKind(KindOfRental kind) {
        this.kind = kind;
    }


    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getBasePrice() {
        return 1;
    }

    private double amountFor() {
        double result;
        result = getDays() * getBasePrice();
        if (getDays() > 7) {
            result *= 3;
        }
        switch (kind) {
            case FIRST:
                return result * 1.5;
            case SECOND:
                return result * 2;
            case THIRD:
                return result * 2.5;
            default:
                return result * 1.5;
        }
    }
    enum KindOfRental {
        FIRST,
        SECOND,
        THIRD
    }
}
