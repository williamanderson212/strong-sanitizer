package me.wando.model;

import lombok.Data;

import java.util.List;

@Data
public class Workout {

    private String title;
    private List<Exercise> exercises;
}
