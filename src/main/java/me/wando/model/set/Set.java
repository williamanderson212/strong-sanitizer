package me.wando.model.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.wando.model.enumeration.SetType;

@Data
@AllArgsConstructor
public class Set {

    private SetType setType;
}
