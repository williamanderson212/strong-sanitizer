package me.wando.entity;

import lombok.Data;
import me.wando.enumeration.SetType;

@Data
public class Set {
    private double weightKg;
    private int reps;
    private SetType setType;

    @Override
    public String toString() {
        if (setType != SetType.WARM_UP) {

            StringBuilder builder = new StringBuilder();

            builder.append(weightKg).append("kg x ");
            builder.append(reps);

            if (setType == SetType.DROP_SET) {
                builder.append(" D");
            } else if (setType == SetType.FAILURE) {
                builder.append(" F");
            }

            builder.append("\n");

            return builder.toString();
        } else {
            return "";
        }
    }
}
