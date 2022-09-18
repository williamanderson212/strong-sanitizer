package me.wando.model.set;

import lombok.Data;
import me.wando.model.enumeration.SetType;

@Data
public class CardioSet extends Set {

    private double distance;
    private String time;

    public CardioSet(SetType setType, String time, double distance) {

        super(setType);
        this.time = time;
        this.distance = distance;
    }
}
