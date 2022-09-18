package me.wando.model.set;

import lombok.Data;
import me.wando.model.enumeration.SetType;

@Data
public class RepsSet extends Set {

    protected int reps;

    public RepsSet(SetType setType, int reps) {

        super(setType);
        this.reps = reps;
    }
}
