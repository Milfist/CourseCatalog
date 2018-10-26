package model;

public class Course {

    private String title;
    private Integer numberHours;
    private Boolean active;
    private Level level;

    public Course() {
    }

    public Course(String title, Integer numberHours, Boolean active, Level level) {
        this.title = title;
        this.numberHours = numberHours;
        this.active = active;
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberHours() {
        return numberHours;
    }

    public void setNumberHours(Integer numberHours) {
        this.numberHours = numberHours;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
