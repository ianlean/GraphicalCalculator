package com.company;

class DecToHex implements Converter {
    @Override
    public String convert(String s) {
        boolean neg = false;
        try {
            int n = Integer.parseInt(s);
            if (n < 0) {
                neg = true;
                n *= -1;
            }
            if (neg) {
                return "-" + Integer.toHexString(n);
            }
            return Integer.toHexString(n);
        } catch (NumberFormatException e) {
            return "Error: not a number";
        }
    }
}
