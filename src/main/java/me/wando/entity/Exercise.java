package me.wando.entity;

import lombok.Data;

import java.util.List;

@Data
public class Exercise {
    private String title;
    private List<Set> sets;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(title).append("\n");

        for (Set set : sets) {
            builder.append(set.toString());
        }

        return builder.toString();
    }
}
