package me.wando.sanitizer;

import me.wando.entity.Exercise;
import me.wando.entity.Set;
import me.wando.entity.Workout;
import me.wando.enumeration.SetType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputProcessor {

    public Workout createWorkout(String data) {
        return extractWorkout(removeBlankLinesAndNotes(data));
    }

    private Workout extractWorkout(String cleanData) {
        Scanner scanner = new Scanner(cleanData);
        Workout workout = new Workout();

        workout.setTitle(scanner.nextLine());
        scanner.nextLine();
        workout.setExercises(extractExercises(scanner));

        return workout;
    }

    private List<Exercise> extractExercises(Scanner scanner) {
        List<Exercise> exercises = new ArrayList<>();
        List<Set> sets = new ArrayList<>();
        Exercise exercise = null;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (!line.startsWith("Set ")) {
                if (exercise != null) {
                    exercise.setSets(sets);
                    sets = new ArrayList<>();
                    exercises.add(exercise);
                }

                exercise = new Exercise();
                exercise.setTitle(line);
            } else {
                sets.add(extractSet(line));
            }
        }

        if (exercise != null) {
            exercise.setSets(sets);
        }
        exercises.add(exercise);

        return exercises;
    }

    private Set extractSet(String line) {
        Set set = new Set();

        set.setWeightKg(Double.parseDouble(line.substring(line.indexOf(':') + 1, line.indexOf("k"))));

        if (line.endsWith(SetType.WARM_UP.getStringValue())) {
            set.setSetType(SetType.WARM_UP);
        } else if (line.endsWith(SetType.DROP_SET.getStringValue())) {
            set.setSetType(SetType.DROP_SET);
        } else if (line.endsWith(SetType.FAILURE.getStringValue())) {
            set.setSetType(SetType.FAILURE);
        } else {
            set.setSetType(SetType.NORMAL);
        }

        if (set.getSetType() == SetType.NORMAL) {
            set.setReps(Integer.parseInt(line.substring(line.indexOf("×") + 2)));
        } else {
            set.setReps(Integer.parseInt(line.substring(line.indexOf("×") + 2, line.indexOf("[") - 1)));
        }

        return set;
    }

    private String removeBlankLinesAndNotes(String data) {
        Scanner scanner = new Scanner(data);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.startsWith("Workout Notes:") || line.startsWith(" https://strong.app.link/")) {
                break;
            }

            if (!line.equals("") && !line.startsWith("Notes:")) {
                builder.append(line);
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
