package com.company;

/**
 * This class provides
 * the user with arithmetic
 * in base 10 decimals.
 * @author Ian McLean
 * @version 1.0
 */
class Decimal implements CalculatorNumber {

    /**
     * Provides a method to do arithmetic
     * in normal base 10 format.
     *
     * @param first - left-hand side of the equation.
     * @param op - the operation being performed.
     * @param second - right-hand side of the equation.
     */
    public String arithmetic(String first, String op, String second) {
        double output = 0;
        try {
            double n1 = Double.parseDouble(first);
            double n2 = Double.parseDouble(second);
            switch (op) {
                case "+" -> output = n1 + n2;
                case "-" -> output = n1 - n2;
                case "*" -> output = n1 * n2;
                case "/" -> output = n1 / n2;
            }
        } catch(NumberFormatException e) {
            return "Error: not a number";
        }
        return Double.toString(output);
    }
}
