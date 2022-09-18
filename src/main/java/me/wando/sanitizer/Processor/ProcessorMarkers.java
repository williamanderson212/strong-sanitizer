package me.wando.sanitizer.Processor;

// All processor markers have leading underscore, and can be any length
public class ProcessorMarkers {

    // Base
    public static final String _EMPTY         = "";
    public static final String _NEWLINE       = System.lineSeparator();
    public static final String _SPACE         = " ";

    // Line markers
    public static final String _APP_LINK      = " https://strong.app.link/";
    public static final String _NOTES         = "Notes:";
    public static final String _REPS          = "reps";
    public static final String _SET           = "Set ";
    public static final String _WORKOUT_NOTES = "Workout Notes:";

    // Symbols
    public static final String _BAR           = "km|";
    public static final String _BRACKET       = "[";
    public static final String _COLON         = ":";
    public static final String _MINUS         = "−";
    public static final String _PLUS          = "+";
    public static final String _X             = "kg×";

    // Set types
    public static final String _DROP          = "[DropSet]";
    public static final String _FAIL          = "[Failure]";
    public static final String _WARM_UP       = "[Warm-up]";
}
