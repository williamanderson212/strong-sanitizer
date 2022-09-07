package me.wando.domain;

import lombok.Data;
import me.wando.enumeration.WeightType;

import static me.wando.enumeration.SetType.WARM_UP;

@Data
public class WeightAndRepsSet extends Set {
    private WeightType weightType = WeightType.NORMAL; // Default
    private double weight;
    private int reps;

    @Override
    public String toString() {
        if (super.getSetType() == WARM_UP) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        builder.append(weightType.getStringValue());
        builder.append(weight).append("kg ");
        builder.append("x ").append(reps);
        builder.append(super.toString()).append("\n");

        return builder.toString();
    }
}
