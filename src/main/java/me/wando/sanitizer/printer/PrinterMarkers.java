package me.wando.sanitizer.printer;

import static java.lang.System.lineSeparator;

// All printer markers are denoted by a trailing underscore, and can be any length
public class PrinterMarkers {

    // Base
    public static final String EMPTY_ = "";
    public static final String NEWLINE_ = lineSeparator();

    // Symbols
    public static final String BAR_ = " | ";
    public static final String COLON_ = ": ";
    public static final String MINUS_ = "-";
    public static final String PLUS_ = "+";
    public static final String REPS_ = " reps";
    public static final String X_ = " x ";

    // Set types
    public static final String DROP_ = " D";
    public static final String FAIL_ = " F";
}
