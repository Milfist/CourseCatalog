package model;

public enum Level {

    BASIC("Básico"),
    MEDIUM("Medio"),
    ADVANCED("Avanzado");

    private String level;

    Level(String level) {
    }

    public String getLevel() {
        return level;
    }
}
