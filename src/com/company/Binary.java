package com.company;

/**
 * This class provides
 * the user with arithmetic
 * in binary.
 * @author Ian McLean
 * @version 1.0
 */
class Binary implements CalculatorNumber {

    /**
     * Provides a method to do arithmetic
     * in binary.
     *
     * @param first - left-hand side of the equation.
     * @param op - the operation being performed.
     * @param second - right-hand side of the equation.
     */
    @Override
    public String arithmetic(String first, String op, String second) {
        int output = 0;

        check(second);
        if(!check(first) || !check(second)) {
            return "Error: Binary must contain 1 and 0 only";
        }
        int n1 = Integer.parseInt(first, 2);
        int n2 = Integer.parseInt(second, 2);
        switch (op) {
            case "+" -> output = n1 + n2;
            case "-" -> output = n1 - n2;
            case "*" -> output = n1 * n2;
            case "/" -> output = n1 / n2;
        }
        if (output < 0) {
            output *= -1;
            return "-"+Integer.toBinaryString(output);
        }
        return Integer.toBinaryString(output);
    }

    public static boolean check(String s) {
        char[] carr = s.toCharArray();
        for (char c : carr) {
            if (c != '1' && c != '0' && c != '-') {
                return false;
            }
        }
        return true;
    }
}
