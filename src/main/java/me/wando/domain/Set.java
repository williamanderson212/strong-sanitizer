package me.wando.domain;

import lombok.Data;
import me.wando.enumeration.SetType;

import static me.wando.enumeration.SetType.DROP_SET;
import static me.wando.enumeration.SetType.FAILURE;

@Data
public abstract class Set {
    private SetType setType;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (setType == DROP_SET) {
            builder.append(" D");
        } else if (setType == FAILURE) {
            builder.append(" F");
        }

        return builder.toString();
    }
}
