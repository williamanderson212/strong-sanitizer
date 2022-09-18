package me.wando.sanitizer.mapper;

// All mapper markers have no leading or trailing underscores, and can only be of length one
public class MapperMarkers {

    // Base
    public static final String END       = "%";
    public static final String SET       = "$";
    public static final String SPLIT     = "x";

    // Exercise types
    public static final String ASSISTED  = "a";
    public static final String CARDIO    = "c";
    public static final String NORMAL    = "n";
    public static final String REPS_ONLY = "r";
    public static final String TIME_ONLY = "t";
    public static final String WEIGHTED  = "w";

    // Set types
    public static final String DROP      = "d";
    public static final String FAIL      = "f";
    public static final String STRAIGHT  = "s";
}
