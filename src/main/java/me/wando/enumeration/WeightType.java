package me.wando.enumeration;

public enum WeightType {
    ASSISTED("-"),
    WEIGHTED("+"),
    NORMAL("");

    private final String weightType;

    WeightType(String weightType) {
        this.weightType = weightType;
    }

    public String getStringValue() {
        return weightType;
    }
}
