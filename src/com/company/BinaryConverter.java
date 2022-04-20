package com.company;

class BinaryConverter implements Converter {


    @Override
    public String convert(String s) {
        int output;
        if (!check(s)) {
            return "Error Binary can only contain 1 and 0";
        }
        int k = (Integer.parseInt(s, 2));
        return String.valueOf(k);
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
