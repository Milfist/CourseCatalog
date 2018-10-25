package model;

public enum Level {

    BASIC("Basic"),
    MEDIUM("Medium"),
    ADVANCED("Advanced");

    private String level;

    Level(String level) {
    }

    public String getLevel() {
        return level;
    }


}
