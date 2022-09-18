package me.wando.sanitizer.Processor;

import java.util.ArrayList;
import java.util.List;

import static me.wando.sanitizer.Processor.ProcessorMarkers.*;
import static me.wando.sanitizer.mapper.MapperMarkers.*;

public class WorkoutProcessor {

    public static String[] processWorkout(String rawWorkout) {

        // Determine the end index based on whether or not the workout has workout notes
        int workoutEndIndex = rawWorkout.contains(_WORKOUT_NOTES)
                ? rawWorkout.indexOf(_WORKOUT_NOTES)
                : rawWorkout.indexOf(_APP_LINK);

        rawWorkout = rawWorkout.substring(0, workoutEndIndex); // Trim the end

        List<String> output = new ArrayList<>();
        output.add(rawWorkout.substring(0, rawWorkout.indexOf(_NEWLINE))); // Save the title

        String[] input = rawWorkout.split(_NEWLINE);

        for (int i = 2; i < input.length; i++) {

            String line = input[i];

            // Remove notes, blanks, and warmups
            if (!(line.startsWith(_NOTES) || line.isBlank() || line.endsWith(_WARM_UP))) {
                output.add(line);
            }
        }

        output.add(END); // Add a terminator to the end because I suck at loops

        return processSets(output.toArray(new String[0]));
    }

    // Exercise processor
    private static String[] processSets(String[] lines) {

        for (int i = 1; i < lines.length; i++) {

            String line = lines[i];

            // Don't process the exercise titles
            lines[i] = line.startsWith(_SET) ? processSet(line) : line;
        }

        return lines;
    }

    // Set processors
    private static String processSet(String line) {

        line = line.replace(_SPACE, _EMPTY); // Remove all whitespace

        StringBuilder builder = new StringBuilder(SET); // Start with a set marker

        // Determine the exercise type and process accordingly
        if (line.contains(_REPS)) {
            builder.append(processRepsSet(line));
        } else if (line.contains(_BAR)) {
            builder.append(processCardioSet(line));
        } else if (line.contains(_X)) {
            builder.append(processWeightSet(line, getWeightType(line), getSetType(line)));
        } else {
            builder.append(processTimeSet(line));
        }

        return builder.toString();
    }

    private static StringBuilder processCardioSet(String line) {

        StringBuilder builder = new StringBuilder(CARDIO);

        builder.append(line, line.indexOf(_COLON) + 1, line.indexOf(_BAR));
        builder.append(SPLIT);
        builder.append(line, line.indexOf(_BAR) + 3, line.lastIndexOf(_COLON) + 3);
        builder.append(getSetType(line));

        return builder;
    }

    private static StringBuilder processRepsSet(String line) {

        StringBuilder builder = new StringBuilder(REPS_ONLY);
        builder.append(line, line.indexOf(_COLON) + 1, line.indexOf(_REPS));
        builder.append(getSetType(line));

        return builder;
    }

    private static StringBuilder processTimeSet(String line) {

        StringBuilder builder = new StringBuilder(TIME_ONLY);
        builder.append(line, line.indexOf(_COLON) + 1, line.lastIndexOf(_COLON) + 3);
        builder.append(getSetType(line));

        return builder;
    }

    private static StringBuilder processWeightSet(String line, String weightType, String setType) {

        StringBuilder builder = new StringBuilder(weightType);

        // Determine where the weight starts
        int weightStartIndex;
        switch (weightType) {
            case ASSISTED -> weightStartIndex = line.indexOf(_MINUS) + 1;
            case WEIGHTED -> weightStartIndex = line.indexOf(_PLUS) + 1;
            default -> weightStartIndex = line.indexOf(_COLON) + 1;
        }

        builder.append(line, weightStartIndex, line.indexOf(_X));
        builder.append(SPLIT);

        // Determine where the reps end
        int repsEndIndex;
        switch (setType) {
            case DROP, FAIL -> repsEndIndex = line.indexOf(_BRACKET);
            default -> repsEndIndex = line.length();
        }

        builder.append(line, line.indexOf(_X) + 3, repsEndIndex);
        builder.append(getSetType(line));

        return builder;
    }

    // Enum processors
    private static String getSetType(String line) {

        if (line.endsWith(_DROP)) return DROP;
        if (line.endsWith(_FAIL)) return FAIL;

        return STRAIGHT;
    }

    private static String getWeightType(String line) {

        if (line.contains(_MINUS)) return ASSISTED;
        if (line.contains(_PLUS)) return WEIGHTED;

        return NORMAL;
    }
}
