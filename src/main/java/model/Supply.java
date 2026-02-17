package model;

public class Supply {

    private int id;
    private int astronautId;
    private String name;
    private int value;
    private int day;

    public Supply(int id, int astronautId,
                  String name, int value, int day) {

        this.id = id;
        this.astronautId = astronautId;
        this.name = name;
        this.value = value;
        this.day = day;
    }

    public int getAstronautId() { return astronautId; }
    public int getValue() { return value; }
}
