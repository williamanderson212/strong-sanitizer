package me.wando.domain;

import lombok.Data;

import static me.wando.enumeration.SetType.WARM_UP;

@Data
public class CardioSet extends Set {
    private int minutes;
    private int seconds;
    private double distance;

    @Override
    public String toString() {
        if (super.getSetType() == WARM_UP) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        builder.append(distance).append("km | ");
        builder.append(minutes).append(":");

        if (seconds < 10) {
            builder.append("0");
        }

        builder.append(seconds);
        builder.append(super.toString()).append("\n");

        return builder.toString();
    }
}
