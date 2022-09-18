package me.wando.sanitizer.mapper;

import me.wando.model.Exercise;
import me.wando.model.Workout;
import me.wando.model.enumeration.SetType;
import me.wando.model.enumeration.WeightType;
import me.wando.model.set.CardioSet;
import me.wando.model.set.RepsSet;
import me.wando.model.set.Set;
import me.wando.model.set.TimeSet;
import me.wando.model.set.WeightSet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static me.wando.sanitizer.Processor.WorkoutProcessor.processWorkout;
import static me.wando.sanitizer.mapper.MapperMarkers.*;

public class WorkoutMapper {

    public static Workout mapWorkout(String rawWorkout) {

        String[] input = processWorkout(rawWorkout); // Convert the string to a more readable array

        Workout workout = new Workout();
        workout.setTitle(input[0]);
        workout.setExercises(mapExercises(input));

        return workout;
    }

    // Exercise mapper
    private static List<Exercise> mapExercises(String[] input) {

        List<Exercise> exercises = new ArrayList<>();

        for (int i = 1; i < input.length; ) {

            if (!(input[i].startsWith(SET))) { // Check for title lines

                Exercise exercise = new Exercise();
                List<Set> sets = new ArrayList<>();

                exercise.setTitle(input[i++]); // Iterate onto the first set line


                while (input[i].startsWith(SET)) {

                    sets.add(mapSet(input[i]));
                    i++; // Only iterate on set lines
                }

                exercise.setSets(sets);
                exercises.add(exercise);

                if (input[i].equals(END)) break; // Exit on the terminator
            }
        }

        return exercises;
    }

    // Set mappers
    private static Set mapSet(String input) {

        int startIndex = 1;
        int endIndex = 2;

        return switch (input.substring(startIndex, endIndex)) {

            case TIME_ONLY -> mapTimeSet(input);
            case CARDIO -> mapCardioSet(input);
            case REPS_ONLY -> mapRepsSet(input);

            default -> mapWeightAndRepsSet(input);
        };
    }

    private static TimeSet mapTimeSet(String input) {

        int startIndex = input.indexOf(TIME_ONLY) + 1;
        int endIndex = input.length() - 1;

        String time = input.substring(startIndex, endIndex);
        SetType setType = getSetType(input);

        return new TimeSet(setType, time);
    }

    private static CardioSet mapCardioSet(String input) {

        int startIndex = input.indexOf(CARDIO) + 1;
        int splitIndex = input.indexOf(SPLIT);
        int endIndex = input.length() - 1;

        double distance = parseDouble(input.substring(startIndex, splitIndex++));
        String time = input.substring(splitIndex, endIndex);
        SetType setType = getSetType(input);

        return new CardioSet(setType, time, distance);
    }

    private static RepsSet mapRepsSet(String input) {

        int startIndex = input.indexOf(REPS_ONLY) + 1;
        int endIndex = input.length() - 1;

        int reps = parseInt(input.substring(startIndex, endIndex));
        SetType setType = getSetType(input);

        return new RepsSet(setType, reps);
    }

    private static WeightSet mapWeightAndRepsSet(String input) {

        int startIndex = 2;
        int splitIndex = input.indexOf(SPLIT);
        int endIndex = input.length() - 1;

        WeightType weightType = getWeightType(input);
        double weight = parseDouble(input.substring(startIndex, splitIndex++));
        int reps = parseInt(input.substring(splitIndex, endIndex));
        SetType setType = getSetType(input);

        return new WeightSet(setType, reps, weight, weightType);
    }

    // Enumeration mappers
    private static SetType getSetType(String input) {

        int setTypeIndex = input.length() - 1;

        return switch (input.substring(setTypeIndex)) {

            case DROP -> SetType.DROP;
            case FAIL -> SetType.FAILURE;

            default -> SetType.STRAIGHT;
        };
    }

    private static WeightType getWeightType(String input) {

        int startIndex = 1;
        int endIndex = 2;

        return switch (input.substring(startIndex, endIndex)) {

            case ASSISTED -> WeightType.ASSISTED;
            case WEIGHTED -> WeightType.WEIGHTED;

            default -> WeightType.NORMAL;
        };
    }
}
