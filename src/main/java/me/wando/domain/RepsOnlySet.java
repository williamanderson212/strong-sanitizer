package me.wando.domain;

import lombok.Data;

import static me.wando.enumeration.SetType.WARM_UP;

@Data
public class RepsOnlySet extends Set {
    private int reps;

    @Override
    public String toString() {
        if (super.getSetType() == WARM_UP) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        builder.append(reps).append(" Reps");
        builder.append(super.toString()).append("\n");

        return builder.toString();
    }
}
