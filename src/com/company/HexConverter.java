package com.company;

public class HexConverter implements Converter{

    @Override
    public String convert(String s) {
        try {
            return String.valueOf(Integer.parseInt(s, 16));
        } catch(NumberFormatException e) {
            return "Error: not a hexadecimal";
        }
    }
}
