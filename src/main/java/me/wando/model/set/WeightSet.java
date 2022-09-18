package me.wando.model.set;

import lombok.Data;
import me.wando.model.enumeration.SetType;
import me.wando.model.enumeration.WeightType;

@Data
public class WeightSet extends Set {

    private WeightType weightType;
    private double weight;
    private int reps;

    public WeightSet(SetType setType, int reps, double weight, WeightType weightType) {

        super(setType);
        this.weightType = weightType;
        this.weight = weight;
        this.reps = reps;
    }
}
