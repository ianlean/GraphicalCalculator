package com.company;

/**
 * This class provides
 * the user with arithmetic
 * in hexadecimal.
 * @author Ian McLean
 * @version 1.0
 */
class Hexadecimal implements CalculatorNumber {

    /**
     * Provides a method to do arithmetic
     * in hexadecimal.
     *
     * @param first - left-hand side of the equation.
     * @param op - the operation being performed.
     * @param second - right-hand side of the equation.
     */
    @Override
    public String arithmetic(String first, String op, String second) {
        int output = 0;
        try {
            int n1 = Integer.parseInt(first, 16);
            int n2 = Integer.parseInt(second, 16);
            switch (op) {
                case "+" -> output = n1 + n2;
                case "-" -> output = n1 - n2;
                case "*" -> output = n1 * n2;
                case "/" -> output = n1 / n2;
            }
        } catch(NumberFormatException e) {
            return "Error: not a hexadecimal";
        }

        if (output < 0) {
            output *= -1;
            return "-"+Integer.toHexString(output);
        }
        return Integer.toHexString(output);
    }
}

