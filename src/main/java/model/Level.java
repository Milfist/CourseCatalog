package model;

public enum Level {

    BASIC("BASIC"),
    MEDIUM("MEDIUM"),
    ADVANCED("ADVANCED");

    private String level;

    Level(String level) {
    }

    public String getLevel() {
        return level;
    }


}
