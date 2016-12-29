package com.userok.learning.softgrouptest;


/**
 * The class {@code N2Polynomial} contains a public
 * method for calculating polynomial's value and
 * */
public class N2Polynomial {

    private Monomial[] polynomial;    // an array of monomials, sum of these monomials is polynome itself
    private int a;  //variable of the polynome
    private int b;  //variable of the polynome
    private boolean isCalculated;   // flag which idicates if polynom's value is already calculated
    private int value; // calculated value of the polynome

    /**
     * Builds the polynom's model, using Pascal's triangle to
     * obtain polynom's terms(monomials)
     * */
    public N2Polynomial(int a, int b, int n) {
        if (n < 1) throw new IllegalArgumentException("Polynome's exponent must be positive integer");
        this.a = a;
        this.b = b;

        N1Triangle triangle = new N1Triangle();
        int[] coefficients = triangle.calcSingleLine(n); //obtain binomial coefficients for each term
        polynomial = new Monomial[coefficients.length];

        for (int i = 0, j = n; i < coefficients.length; i++, j--) {
            polynomial[i] = new Monomial(coefficients[i], j, i);
        }
        isCalculated = false;
    }

    /**
     * Returns the value of the polynome (sum of all terms)
     * @return the value of the polynome
     * */
    public int calculatedValue() {
        if (isCalculated) return value;
        int result = 0;
        for (Monomial mon : polynomial) {
            result += mon.getC() *
                    (Math.pow(a, mon.getAExp())) *
                    (Math.pow(b, mon.getBExp()));
        }
        isCalculated = true;
        return result;
    }
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < polynomial.length; i++) {
            out += polynomial[i].toString();
            if (i < polynomial.length - 1) out+= "+";
        }
        out += "=" + calculatedValue();
        return out;
    }

    /**
     * The class {@code Monomial} used to represent a single term (monomial)
     * of a polynome
     * */
    static class Monomial {
        //value of the binomial coefficient
        private int c;
        //value of the aExp's exponent
        private int aExp;
        //value of the bExp's exponent
        private int bExp;

        Monomial(int c, int aExp, int bExp) {
            if (c < 1 || aExp < 0 || bExp < 0)
                throw new IllegalArgumentException(
                        "Coefficient must me higher than zero, exponents must be non-negative"
                );
            this.c = c;
            this.aExp = aExp;
            this.bExp = bExp;
        }

        @Override
        public String toString() {
            String sc;
            String sa;
            String sb;
            if (c == 1) sc = "";
            else sc = "" + c;
            switch (aExp) {
                case 0:
                    sa = "";
                    break;
                case 1:
                    sa = "a";
                    break;
                default:
                    sa = "a^" + aExp;
            }
            switch (bExp) {
                case 0:
                    sb = "";
                    break;
                case 1:
                    sb = "b";
                    break;
                default:
                    sb = "b^" + bExp;
            }
            if (!(sa.isEmpty() || sb.isEmpty()) && !sc.isEmpty()) sc += "*";
            if (!sb.isEmpty() && !sa.isEmpty()) sa += "*";
            return sc + sa + sb;
        }

        public int getC() {
            return c;
        }

        public int getAExp() {
            return aExp;
        }

        public int getBExp() {
            return bExp;
        }
    }
}
