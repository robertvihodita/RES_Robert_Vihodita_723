package model;

public class Astronaut {

    private int id;
    private String name;
    private String spacecraft;
    private AstronautStatus status;
    private int experienceLevel;

    public Astronaut(int id, String name, String spacecraft,
                     AstronautStatus status, int experienceLevel) {

        this.id = id;
        this.name = name;
        this.spacecraft = spacecraft;
        this.status = status;
        this.experienceLevel = experienceLevel;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpacecraft() { return spacecraft; }
    public AstronautStatus getStatus() { return status; }
    public int getExperienceLevel() { return experienceLevel; }

    @Override
    public String toString() {
        return String.format("[#%d] %s | %s | %s | exp=%d",
                id, name, spacecraft, status, experienceLevel);
    }
}
