package com.company;

/**
 * This class is an interface
 * that when implemented allows its
 * subclasses to do arithmetic operations.
 * @author Ian McLean
 * @version 1.0
 */
public interface CalculatorNumber {

    /**
     * Provides a method to do arithmetic
     * for the kind of number you are using.
     *
     * @param first - left-hand side of the equation.
     * @param op - the operation being performed.
     * @param second - right-hand side of the equation.
     */
    String arithmetic(String first, String op, String second);
}
