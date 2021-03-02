package com.olexyn.about.java.numbers_currency;



import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumbersCurrency {
    // The format classes are not thread-safe. Do not store them in instance variables or static variables.

    public static void main(String... args) throws ParseException {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        double d = 2.0;
        String formatted = numberFormat.format(d);
        Number parsed = numberFormat.parse(formatted);
        assert d == parsed.doubleValue();


        NumberFormat.getNumberInstance(); // same as getInstance
        NumberFormat.getNumberInstance(Locale.US);
        NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat.getPercentInstance(Locale.US);
        NumberFormat.getIntegerInstance(Locale.US); // rounds before displaying

        NumberFormat germanNumberFormat = NumberFormat.getInstance(Locale.GERMAN);

        formatted = germanNumberFormat.format(123331231312333L).replace('.', '\'');
        int br = 0;

    }

    // Parsing may lead to ParseException
    // parse() parses till the first unknown char,
    // i.e. if . is a invalid char in the selected locale, all the digits after . will be omitted
    // 456abc -> 456
    // -2.4x10 -> -2.4
    // x54.3 -> ParseException
}
