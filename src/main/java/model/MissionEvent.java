package model;

public class MissionEvent {

    private int id;
    private int astronautId;
    private MissionEventType type;
    private int basePoints;
    private int day;

    public MissionEvent(int id, int astronautId,
                        MissionEventType type,
                        int basePoints, int day) {

        this.id = id;
        this.astronautId = astronautId;
        this.type = type;
        this.basePoints = basePoints;
        this.day = day;
    }

    public int getId() { return id; }
    public int getAstronautId() { return astronautId; }
    public MissionEventType getType() { return type; }
    public int getBasePoints() { return basePoints; }
    public int getDay() { return day; }
}
