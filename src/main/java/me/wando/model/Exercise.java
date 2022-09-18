package me.wando.model;

import lombok.Data;
import me.wando.model.set.Set;

import java.util.List;

@Data
public class Exercise {

    private String title;
    private List<Set> sets;
}
