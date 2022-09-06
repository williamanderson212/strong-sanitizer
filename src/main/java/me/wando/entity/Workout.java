package me.wando.entity;

import lombok.Data;

import java.util.List;

@Data
public class Workout {
    private String title;
    private List <Exercise> exercises;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(title).append("\n");

        for (Exercise exercise : exercises) {
            builder.append(exercise.toString()).append("\n");
        }

        return builder.toString();
    }
}
