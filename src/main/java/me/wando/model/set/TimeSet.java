package me.wando.model.set;

import lombok.Data;
import me.wando.model.enumeration.SetType;

@Data
public class TimeSet extends Set {

    protected String time;

    public TimeSet(SetType setType, String time) {

        super(setType);
        this.time = time;
    }
}
