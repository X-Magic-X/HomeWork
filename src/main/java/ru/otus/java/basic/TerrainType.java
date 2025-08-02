package ru.otus.java.basic;

public enum TerrainType {
    DENSE_FOREST("густой лес"),
    PLAIN("равнина"),
    SWAMP("болото");

    private final String description;

    TerrainType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
