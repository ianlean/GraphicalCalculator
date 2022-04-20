package com.company;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class provides
 * the user with arithmetic
 * with big/small numbers.
 * @author Ian McLean
 * @version 1.0
 */
 class BigNumber implements CalculatorNumber {

    /**
     * Provides a method to do arithmetic
     * with very large/small numbers.
     *
     * @param first - left-hand side of the equation.
     * @param op - the operation being performed.
     * @param second - right-hand side of the equation.
     */
    @Override
    public String arithmetic(String first, String op, String second) {
        try {
            BigDecimal n1 = new BigDecimal(first);
            BigDecimal n2 = new BigDecimal(second);

            switch (op) {
                case "+" -> {
                    return n1.add(n2).toString();
                }
                case "-" -> {
                    return n1.subtract(n2).toString();
                }
                case "*" -> {
                    return n1.multiply(n2).toString();
                }
                default -> {
                    MathContext m = new MathContext(4);
                    return n1.divide(n2, m).toString();
                }
            }
        } catch (NumberFormatException e) {
            return "Error: not a number";
        }
    }
}
