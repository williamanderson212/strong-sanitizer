package me.wando.sanitizer.printer;

import me.wando.model.Exercise;
import me.wando.model.Workout;
import me.wando.model.set.CardioSet;
import me.wando.model.set.RepsSet;
import me.wando.model.set.Set;
import me.wando.model.set.TimeSet;
import me.wando.model.set.WeightSet;

import static me.wando.sanitizer.mapper.WorkoutMapper.mapWorkout;
import static me.wando.sanitizer.printer.PrinterMarkers.*;

public class WorkoutPrinter {

    public static String printWorkout(String rawWorkout) {

        Workout workout = mapWorkout(rawWorkout);
        StringBuilder builder = new StringBuilder(workout.getTitle() + NEWLINE_ + NEWLINE_);

        for (Exercise exercise : workout.getExercises()) {

            builder.append(printExercise(exercise));
        }

        return builder.toString();
    }

    // Exercise printer
    private static String printExercise(Exercise exercise) {

        StringBuilder builder = new StringBuilder(exercise.getTitle() + NEWLINE_);

        int setNumber = 1;

        for (Set set : exercise.getSets()) {

            builder.append(printSet(set, setNumber++)); // Number the printed sets
        }

        builder.append(NEWLINE_);

        return builder.toString();
    }

    // Set printers
    private static String printSet(Set set, int setNumber) {

        if (set instanceof TimeSet)   return printTimeSet((TimeSet) set, setNumber);
        if (set instanceof CardioSet) return printCardioSet((CardioSet) set, setNumber);
        if (set instanceof RepsSet)   return printRepsSet((RepsSet) set, setNumber);

        return printWeightSet((WeightSet) set, setNumber);
    }

    private static String printCardioSet(CardioSet set, int setNumber) {

        StringBuilder builder = new StringBuilder(setNumber + COLON_);

        builder.append(set.getDistance()).append(BAR_);
        builder.append(set.getTime());
        builder.append(getSetType(set)).append(NEWLINE_);

        return builder.toString();
    }

    private static String printRepsSet(RepsSet set, int setNumber) {

        StringBuilder builder = new StringBuilder(setNumber + COLON_);

        builder.append(set.getReps()).append(REPS_);
        builder.append(getSetType(set)).append(NEWLINE_);

        return builder.toString();
    }

    private static String printTimeSet(TimeSet set, int setNumber) {

        StringBuilder builder = new StringBuilder(setNumber + COLON_);

        builder.append(set.getTime());
        builder.append(getSetType(set)).append(NEWLINE_);

        return builder.toString();
    }

    private static String printWeightSet(WeightSet set, int setNumber) {

        StringBuilder builder = new StringBuilder(setNumber + COLON_);

        builder.append(getWeightType(set));
        builder.append(set.getWeight()).append(X_);
        builder.append(set.getReps());
        builder.append(getSetType(set)).append(NEWLINE_);

        return builder.toString();
    }

    // Enum printers
    private static String getSetType(Set set) {

        return switch (set.getSetType()) {

            case DROP -> DROP_;
            case FAILURE -> FAIL_;
            default -> EMPTY_;
        };
    }

    private static String getWeightType(WeightSet set) {

        return switch (set.getWeightType()) {

            case ASSISTED -> MINUS_;
            case WEIGHTED -> PLUS_;
            default -> EMPTY_;
        };
    }
}
