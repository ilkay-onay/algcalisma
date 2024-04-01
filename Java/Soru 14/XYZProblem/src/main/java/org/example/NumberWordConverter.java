package org.example;
import java.util.*;

public class NumberWordConverter {
    public static final String[] units = {
            "", "bir", "iki", "uc", "dort", "bes", "alti", "yedi",
            "sekiz", "dokuz"
    };

    public static final String[] tens = {
            "",        // 0
            "on",        // 1
            "yirmi",  // 2
            "otuz",  // 3
            "kirk",   // 4
            "elli",   // 5
            "altmis",   // 6
            "yetmis", // 7
            "sekzen",  // 8
            "doksan"   // 9
    };

    public static String convert(final int n) {
        if (n < 0) {
            return "minus " + convert(-n);
        }

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + " yuz" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }

        if (n < 1000000) {
            return convert(n / 1000) + " bin" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
        }

        if (n < 1000000000) {
            return convert(n / 1000000) + " milyon" + ((n % 1000000 != 0) ? " " : "") + convert(n % 1000000);
        }

        return convert(n / 1000000000) + " milyar" + ((n % 1000000000 != 0) ? " " : "") + convert(n % 1000000000);
    }
}