package me.wando.enumeration;

public enum SetType {
    WARM_UP("[Warm-up]"),
    FAILURE("[Failure]"),
    DROP_SET("[Drop Set]"),
    NORMAL("Normal");

    private final String setType;

    SetType(String setType) {
        this.setType = setType;
    }

    public String getStringValue() {
        return setType;
    }
}
