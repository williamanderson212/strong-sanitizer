package me.wando.domain;

import lombok.Data;

import static me.wando.enumeration.SetType.WARM_UP;

@Data
public class DurationOnlySet extends Set {
    private int minutes;
    private int seconds;

    @Override
    public String toString() {
        if (super.getSetType() == WARM_UP) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(minutes).append(":");

        if (seconds < 10) {
            builder.append("0");
        }

        builder.append(seconds);
        builder.append(super.toString()).append("\n");

        return builder.toString();
    }
}
