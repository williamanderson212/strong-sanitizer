package me.wando.sanitizer;

import me.wando.entity.Exercise;
import me.wando.entity.Set;
import me.wando.entity.Workout;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputProcessorTest {

    private static final String RESOURCES_PATH = "C:\\Users\\carri\\IdeaProjects\\strong-sanitizer\\src\\main\\resources\\test-files\\";

    InputProcessor inputProcessor = new InputProcessor();

    @Test
    public void testWandoMondayWorkout() {
        String testData = getWorkoutStringFromFile(RESOURCES_PATH + "wando-thursday-workout.txt");

        Workout workout = inputProcessor.createWorkout(testData);

        System.out.println(workout.toString());
    }

    @Test
    public void testWandoTuesdayWorkout() {
        String testData = getWorkoutStringFromFile(RESOURCES_PATH + "wando-tuesday-workout.txt");

        System.out.println(new JSONObject(inputProcessor.createWorkout(testData)));
    }

    @Test
    public void testWandoThursdayWorkout() {
        String testData = getWorkoutStringFromFile(RESOURCES_PATH + "wando-thursday-workout.txt");

        System.out.println(new JSONObject(inputProcessor.createWorkout(testData)));
    }

    @Test
    public void testWandoFridayWorkout() {
        String testData = getWorkoutStringFromFile(RESOURCES_PATH + "wando-friday-workout.txt");

        System.out.println(new JSONObject(inputProcessor.createWorkout(testData)));
    }

    private String getWorkoutStringFromFile(String path) {
        String content;

        try {
            content = Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content;
    }
}
